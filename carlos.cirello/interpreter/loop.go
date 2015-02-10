/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	fe "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *fe.Event
	receive      chan *fe.Event
	execute      visitor

	symbolTable map[string]*ast.QuestionNode
	symbolChan  chan *symbolEvent
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *fe.Event, chan *fe.Event) {
	toFrontend := make(chan *fe.Event)
	fromFrontend := make(chan *fe.Event)
	symbolChan := make(chan *symbolEvent)
	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		execute:      &execute{toFrontend, symbolChan},
		symbolTable:  make(map[string]*ast.QuestionNode),
		symbolChan:   symbolChan,
	}
	go v.updateSymbolTable()
	go v.loop()
	return toFrontend, fromFrontend
}

func (v *interpreter) updateSymbolTable() {
	for r := range v.symbolChan {
		if r.command == SymbolRead {
			question, ok := v.symbolTable[r.name]
			if !ok {
				log.Panicf("Identifier unknown: %s", r.name)
			}
			r.ret <- question
		} else if r.command == SymbolCreate {
			if _, ok := v.symbolTable[r.name]; !ok {
				v.symbolTable[r.name] = r.content
			}
		} else if r.command == SymbolUpdate {
			if _, ok := v.symbolTable[r.name]; ok {
				v.symbolTable[r.name] = r.content
			}
		} else {
			log.Panicf("Invalid operation at symbols table: %s", r.command)
		}
	}
}

func (v *interpreter) loop() {
	v.send <- &fe.Event{
		Type: fe.ReadyP,
	}

	for {
		select {
		case r := <-v.receive:
			if r.Type == fe.ReadyT {
				// visit everything to setup interface
				v.execute.QuestionaireNode(v.questionaire)
				v.send <- &fe.Event{
					Type: fe.Flush,
				}
			} else if r.Type == fe.Answers {
				for identifier, answer := range r.Answers {
					ret := make(chan *ast.QuestionNode)
					v.symbolChan <- &symbolEvent{
						command: SymbolRead,
						name:    identifier,
						ret:     ret,
					}

					q := <-ret
					q.Content.From(answer)
					v.symbolChan <- &symbolEvent{
						command: SymbolUpdate,
						name:    q.Identifier,
						content: q,
					}
				}
				// visit everything again
				v.execute.QuestionaireNode(v.questionaire)
				v.send <- &fe.Event{
					Type: fe.Flush,
				}
			}
		default:
			v.send <- &fe.Event{
				Type: fe.FetchAnswers,
			}
		}
	}

}
