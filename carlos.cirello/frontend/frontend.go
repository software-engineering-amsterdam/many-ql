/*
Package frontend is the set of goroutines which interface with VM and the user.
The interface with the user can be either Graphic, Text or Web.
*/
package frontend

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	DrawQuestion(
		identifier,
		label,
		typ string,
		content ast.Parser,
		visible event.Visibility,
	)
	UpdateQuestion(
		identifier,
		label,
		typ string,
		content ast.Parser,
	)
	Loop()
	Flush()
	FetchAnswers() map[string]string
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fromVM, toVM chan *event.Frontend, driver Inputer) {
	f := &frontend{
		receive: fromVM,
		send:    toVM,
		driver:  driver,
	}

	go f.loop()
}

type frontend struct {
	receive chan *event.Frontend
	send    chan *event.Frontend

	driver Inputer
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			switch r.Type {
			case event.ReadyP:
				f.send <- &event.Frontend{
					Type: event.ReadyT,
				}

			case event.DrawQuestion:
				f.driver.DrawQuestion(
					r.Question.Identifier(),
					r.Question.Label(),
					r.Question.Type(),
					r.Question.Content(),
					r.Visible,
				)

			case event.UpdateQuestion:
				f.driver.UpdateQuestion(
					r.Question.Identifier(),
					r.Question.Label(),
					r.Question.Type(),
					r.Question.Content(),
				)

			case event.Flush:
				f.driver.Flush()

			case event.FetchAnswers:
				fetchedAnswers := f.driver.FetchAnswers()
				if len(fetchedAnswers) > 0 {
					f.send <- &event.Frontend{
						Type:    event.Answers,
						Answers: fetchedAnswers,
					}
				}
			}
		default:
			//noop
		}
	}
}
