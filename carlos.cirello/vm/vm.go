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
	questionaire *ast.Questionaire
	send         chan *fe.Event
	receive      chan *fe.Event
}

// New starts VM with an AST (*ast.Questionaire) and with
// channels to communicate with Frontend process
func New(q *ast.Questionaire, toFrontend, fromFrontend chan *fe.Event) {
	v := &vm{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
	}
	v.loop()
}

func (v *vm) loop() {
	emptyQuestion := &ast.Question{}
	v.send <- &fe.Event{fe.READY_P, *emptyQuestion}

listenLoop:
	for {
		select {
		case r := <-v.receive:
			if r.Type == fe.READY_T {
				for _, q := range v.questionaire.Questions {
					questionCopy := q.Clone()
					v.send <- &fe.Event{
						Type:     fe.RENDER,
						Question: questionCopy,
					}
				}
			} else if r.Type == fe.ANSWER {
				for k, q := range v.questionaire.Questions {
					if q.Label == r.Question.Label {
						newQuestion := r.Question.Clone()
						v.questionaire.Questions[k] = &newQuestion
					}
				}
			}
		default:
			allAnswered := true
			for _, question := range v.questionaire.Questions {
				if !question.Answered {
					allAnswered = false
					break
				}
			}
			if allAnswered {
				break listenLoop
			}
		}
	}

	log.Println("Answers")
	for _, question := range v.questionaire.Questions {
		log.Println(question.Label, question.Content)
	}
}
