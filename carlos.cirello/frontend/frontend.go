/*
Package frontend is the set of goroutines which interface with VM and the user.
The interface with the user can be either Graphic, Text or Web.
*/
package frontend

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
)

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	DrawQuestion(q *ast.QuestionNode, visible interpreter.Visibility)
	UpdateQuestion(q *ast.QuestionNode)
	Loop()
	Flush()
	FetchAnswers() map[string]string
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fromVM, toVM chan *interpreter.Event, driver Inputer) {
	f := &frontend{
		receive: fromVM,
		send:    toVM,
		driver:  driver,
	}

	go f.loop()
}

type frontend struct {
	receive chan *interpreter.Event
	send    chan *interpreter.Event

	driver Inputer
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			switch r.Type {
			case interpreter.ReadyP:
				f.send <- &interpreter.Event{
					Type: interpreter.ReadyT,
				}

			case interpreter.DrawQuestion:
				f.driver.DrawQuestion(&r.Question, r.Visible)

			case interpreter.UpdateQuestion:
				f.driver.UpdateQuestion(&r.Question)

			case interpreter.Flush:
				f.driver.Flush()

			case interpreter.FetchAnswers:
				fetchedAnswers := f.driver.FetchAnswers()
				if len(fetchedAnswers) > 0 {
					f.send <- &interpreter.Event{
						Type:    interpreter.Answers,
						Answers: fetchedAnswers,
					}
				}
			}
		default:
			//noop
		}
	}
}
