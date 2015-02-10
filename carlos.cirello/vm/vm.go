/*
Package vm is the runtime which executes the AST created from the compiler.
*/
package vm

import (
	"log"

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
				// visit everything to setup interface
				visitQuestionaire(v.questionaire, v.send)
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
					// visit everything again
					visitQuestionaire(v.questionaire, v.send)
				}
			}
		default:
			v.send <- &fe.Event{
				Type: fe.FetchAnswers,
			}
		}
	}

}

func visitQuestionaire(q *ast.QuestionaireNode, toFrontend chan *fe.Event) {
	for _, actionNode := range q.Stack {
		visitActionNode(actionNode, toFrontend)
	}
}

func visitActionNode(a *ast.ActionNode, toFrontend chan *fe.Event) {
	if nil != a.QuestionNode {
		visitQuestionNode(a.QuestionNode, toFrontend)
	} else if nil != a.IfNode {
		visitIfNode(a.IfNode, toFrontend)
	}
}

func visitQuestionNode(q *ast.QuestionNode, toFrontend chan *fe.Event) {
	questionCopy := q.Clone()
	toFrontend <- &fe.Event{
		Type:     fe.Render,
		Question: questionCopy,
	}
}

func visitIfNode(i *ast.IfNode, toFrontend chan *fe.Event) {
	log.Println("Ignoring IfNodes for now")
}
