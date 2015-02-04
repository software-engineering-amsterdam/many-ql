// Package frontend is the set of goroutines which interface with VM and the user. The interface with the user can be either Graphic, Text or Web.
package frontend

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	InputQuestion(q *question.Question)
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fe Inputer) (rec, sen chan *Event) {
	rec = make(chan *Event)
	sen = make(chan *Event)

	f := &frontend{
		receive: rec,
		send:    sen,
		fe:      fe,
	}

	go f.loop()

	return rec, sen
}

type frontend struct {
	receive chan *Event
	send    chan *Event

	fe Inputer
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			log.Println("Frontend got:", r)
			if r.Type == READY_P {
				f.send <- &Event{READY_T, nil}
			} else if r.Type == RENDER {
				log.Println(r.Content.(*question.Question))
			}
		}
	}
}
