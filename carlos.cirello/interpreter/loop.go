/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"log"
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/draw"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/execute"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *event.Event
	receive      chan *event.Event
	execute      *visitor.Visitor
	draw         *visitor.Visitor

	symbolTable map[string]*ast.QuestionNode
	symbolChan  chan *event.Symbol
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *event.Event, chan *event.Event) {
	toFrontend := make(chan *event.Event)
	fromFrontend := make(chan *event.Event)
	symbolChan := make(chan *event.Symbol)
	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		execute:      execute.New(toFrontend, symbolChan),
		draw:         draw.New(toFrontend),
		symbolTable:  make(map[string]*ast.QuestionNode),
		symbolChan:   symbolChan,
	}
	go v.updateSymbolTable()
	go v.loop()
	return toFrontend, fromFrontend
}

func (v *interpreter) updateSymbolTable() {
	for r := range v.symbolChan {
		switch r.Command {
		default:
			log.Fatalf("Invalid operation at symbols table: %#v",
				r.Command)
		case event.SymbolRead:
			question, ok := v.symbolTable[r.Name]
			if !ok {
				log.Fatalf("Identifier unknown: %s", r.Name)
			}
			r.Ret <- question
		case event.SymbolCreate:
			if _, ok := v.symbolTable[r.Name]; !ok {
				v.symbolTable[r.Name] = r.Content
			}
		case event.SymbolUpdate:
			if _, ok := v.symbolTable[r.Name]; ok {
				v.symbolTable[r.Name] = r.Content
			}
		}
	}
}

func (v *interpreter) loop() {
	v.send <- &event.Event{
		Type: event.ReadyP,
	}
walkLoop:
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case event.ReadyT:
				v.draw.Visit(v.questionaire)
				v.send <- &event.Event{Type: event.Flush}
				break walkLoop
			}
		}
	}

	ticker := time.Tick(100 * time.Millisecond)
	for {
		select {
		case r := <-v.receive:
			switch r.Type {
			case event.Answers:
				for identifier, answer := range r.Answers {
					v.execute.Visit(v.questionaire)
					v.send <- &event.Event{Type: event.Flush}
					ret := make(chan *ast.QuestionNode)
					v.symbolChan <- &event.Symbol{
						Command: event.SymbolRead,
						Name:    identifier,
						Ret:     ret,
					}

					q := <-ret
					q.Content().From(answer)
					v.symbolChan <- &event.Symbol{
						Command: event.SymbolUpdate,
						Name:    q.Identifier(),
						Content: q,
					}
				}
				fallthrough

			case event.ReadyT:
				v.execute.Visit(v.questionaire)
				v.send <- &event.Event{Type: event.Flush}
			}

		case <-ticker:
			v.send <- &event.Event{Type: event.FetchAnswers}
		}
	}

}
