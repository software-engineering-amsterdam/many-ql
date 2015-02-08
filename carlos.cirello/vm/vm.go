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
func New(q *ast.Questionaire) (chan *fe.Event, chan *fe.Event) {
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
	emptyQuestion := &ast.Question{}
	v.send <- &fe.Event{
		Type:     fe.ReadyP,
		Question: *emptyQuestion,
	}

listenLoop:
	for {
		select {
		case r := <-v.receive:
			if r.Type == fe.ReadyT {
				for _, q := range v.questionaire.Questions {
					questionCopy := q.Clone()
					v.send <- &fe.Event{
						Type:     fe.Render,
						Question: questionCopy,
					}
				}
				emptyQuestion := &ast.Question{}
				v.send <- &fe.Event{
					Type:     fe.Flush,
					Question: *emptyQuestion,
				}
			} else if r.Type == fe.Answer {
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
