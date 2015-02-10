/*
Package interpreter is the runtime which executes the AST created from the compiler.
*/
package interpreter

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	fe "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

type interpreter struct {
	questionaire *ast.QuestionaireNode
	send         chan *fe.Event
	receive      chan *fe.Event
	visitor      *visitor
}

// New starts interpreter with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *fe.Event, chan *fe.Event) {
	toFrontend := make(chan *fe.Event)
	fromFrontend := make(chan *fe.Event)
	v := &interpreter{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
		visitor:      &visitor{toFrontend},
	}
	go v.loop()
	return toFrontend, fromFrontend
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
				v.visitor.QuestionaireNode(v.questionaire)
				v.send <- &fe.Event{
					Type: fe.Flush,
				}
			} else if r.Type == fe.Answers {
				lenAnswers := len(r.Answers)
				if lenAnswers > 0 {
					for k, action := range v.questionaire.Stack {
						if nil == action.QuestionNode {
							continue
						}
						q := action.QuestionNode
						if answer, ok := r.Answers[q.Identifier]; ok {
							v.questionaire.Stack[k].QuestionNode.From(answer)
						}
					}
					// visit everything again
					v.visitor.QuestionaireNode(v.questionaire)
				}
			}
		default:
			v.send <- &fe.Event{
				Type: fe.FetchAnswers,
			}
		}
	}

}
