/*
Package vm is the runtime which executes the AST created from the compiler.
*/
package vm

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	fe "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
)

type vm struct {
	questionaire *ast.QuestionaireNode
	send         chan *fe.Event
	receive      chan *fe.Event
}

// New starts VM with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.QuestionaireNode) (chan *fe.Event, chan *fe.Event) {
	toFrontend := make(chan *fe.Event)
	fromFrontend := make(chan *fe.Event)
	v := &vm{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
	}
	go v.loop()
	return toFrontend, fromFrontend
}

func (v *vm) loop() {
	v.send <- &fe.Event{
		Type: fe.ReadyP,
	}

	for {
		select {
		case r := <-v.receive:
			if r.Type == fe.ReadyT {
				for _, action := range v.questionaire.Stack {
					questionCopy := action.QuestionNode.Clone()
					v.send <- &fe.Event{
						Type:     fe.Render,
						Question: questionCopy,
					}
				}
				v.send <- &fe.Event{
					Type: fe.Flush,
				}
			} else if r.Type == fe.Answers {
				lenAnswers := len(r.Answers)
				if lenAnswers > 0 {
					for k, action := range v.questionaire.Stack {
						q := action.QuestionNode
						if answer, ok := r.Answers[q.Identifier]; ok {
							v.questionaire.Stack[k].QuestionNode.From(answer)
						}
					}
				}
			}
		default:
			v.send <- &fe.Event{
				Type: fe.FetchAnswers,
			}
		}
	}

}
