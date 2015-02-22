/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"log"
	"time"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/symboltable"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/draw"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/execute"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/visitor/typecheck"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *event.Frontend
	receive      chan *event.Frontend
	execute      *visitor.Visitor
	draw         *visitor.Visitor
	symbols      *symboltable.SymbolTable
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *event.Frontend, chan *event.Frontend) {
	symbolChan := make(chan *event.Symbol)
	st := symboltable.New(symbolChan)

	tc, tcst := typecheck.New()
	tc.Visit(q)
	if warn := tcst.Warn(); warn != nil {
		for _, e := range warn {
			log.Printf("warning: %s", e)
		}
	}
	if err := tcst.Err(); err != nil {
		for _, e := range err {
			log.Println(e)
		}
		panic("typecheck errors found")
	}

	toFrontend := make(chan *event.Frontend)
	fromFrontend := make(chan *event.Frontend)
	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		execute:      execute.New(toFrontend, symbolChan),
		draw:         draw.New(toFrontend),
		symbols:      st,
	}
	go v.loop()
	return toFrontend, fromFrontend
}

func (v *interpreter) loop() {
	ticker := time.Tick(100 * time.Millisecond)
	redraw := false
	for {
		v.send <- &event.Frontend{
			Type: event.ReadyP,
		}

	drawLoop:
		for {
			select {
			case r := <-v.receive:
				switch r.Type {
				case event.ReadyT:
					v.draw.Visit(v.questionaire)
					v.send <- &event.Frontend{Type: event.Flush}
					break drawLoop
				}
			}
		}

		if redraw {
			redraw = false
			go func(receive chan *event.Frontend) {
				receive <- &event.Frontend{Type: event.ReadyT}
			}(v.receive)
		}
	mainLoop:
		for {
			select {
			case r := <-v.receive:
				switch r.Type {

				case event.Answers:
					for identifier, answer := range r.Answers {
						v.execute.Visit(v.questionaire)
						v.send <- &event.Frontend{Type: event.Flush}
						ret := make(chan *ast.QuestionNode)
						v.symbols.Events <- &event.Symbol{
							Command: event.SymbolRead,
							Name:    identifier,
							Ret:     ret,
						}

						q := <-ret
						q.Content().From(answer)
						v.symbols.Events <- &event.Symbol{
							Command: event.SymbolUpdate,
							Name:    q.Identifier(),
							Content: q,
						}
					}
					fallthrough

				case event.ReadyT:
					v.execute.Visit(v.questionaire)
					v.send <- &event.Frontend{Type: event.Flush}

				case event.Redraw:
					redraw = true
					break mainLoop

				}

			case <-ticker:
				v.send <- &event.Frontend{Type: event.FetchAnswers}
			}
		}
	}
}
