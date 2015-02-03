package frontend

import (
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

type Inputer interface {
	InputQuestion(q *question.Question)
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
