//Package vm is the runtime which executes the AST created from the compiler.
package vm

import (
	"log"

	fe "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
)

type vm struct {
	questionaire *questionaire.Questionaire
	send         chan *fe.Event
	receive      chan *fe.Event
}

// New starts VM with an AST (*questionaire.Questionaire) and with
// channels to communicate with Frontend process
func New(q *questionaire.Questionaire, toFrontend, fromFrontend chan *fe.Event) {
	v := &vm{
		questionaire: q,
		send:         toFrontend,
		receive:      fromFrontend,
	}
	v.loop()
}

func (v *vm) loop() {
	v.send <- &fe.Event{fe.READY_P, nil}

	for {
		select {
		case r := <-v.receive:
			log.Println("VM got:", r)
			if r.Type == fe.READY_T {
				for _, question := range v.questionaire.Questions {
					v.send <- &fe.Event{
						Type:     fe.RENDER,
						Question: question,
					}
				}
			}
		default:
			//noop
		}
	}
}
