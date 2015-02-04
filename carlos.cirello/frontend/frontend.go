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
func New(driver Inputer) (fromVM, toVM chan *Event) {
	fromVM = make(chan *Event)
	toVM = make(chan *Event)

	f := &frontend{
		receive: fromVM,
		send:    toVM,
		driver:  driver,
	}

	go f.loop()

	return fromVM, toVM
}

type frontend struct {
	receive chan *Event
	send    chan *Event

	driver Inputer
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			log.Println("Frontend got:", r)
			if r.Type == READY_P {
				f.send <- &Event{READY_T, nil}
			} else if r.Type == RENDER {
				log.Println(r.Question)
				f.driver.InputQuestion(r.Question)
			}
		default:
			//noop
		}
	}
}
