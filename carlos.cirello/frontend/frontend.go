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
	DrawQuestion(q *ast.QuestionNode, visible event.Visibility)
	UpdateQuestion(q *ast.QuestionNode)
	Loop()
	Flush()
	FetchAnswers() map[string]string
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fromVM, toVM chan *event.Event, driver Inputer) {
	f := &frontend{
		receive: fromVM,
		send:    toVM,
		driver:  driver,
	}

	go f.loop()
}

type frontend struct {
	receive chan *event.Event
	send    chan *event.Event

	driver Inputer
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			switch r.Type {
			case event.ReadyP:
				f.send <- &event.Event{
					Type: event.ReadyT,
				}

			case event.DrawQuestion:
				f.driver.DrawQuestion(&r.Question, r.Visible)

			case event.UpdateQuestion:
				f.driver.UpdateQuestion(&r.Question)

			case event.Flush:
				f.driver.Flush()

			case event.FetchAnswers:
				fetchedAnswers := f.driver.FetchAnswers()
				if len(fetchedAnswers) > 0 {
					f.send <- &event.Event{
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
