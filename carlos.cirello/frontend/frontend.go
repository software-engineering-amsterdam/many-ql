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
	InputQuestion(q *ast.QuestionNode)
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
			if r.Type == interpreter.ReadyP {
				f.send <- &interpreter.Event{
					Type: interpreter.ReadyT,
				}
			} else if r.Type == interpreter.Render {
				f.driver.InputQuestion(&r.Question)
			} else if r.Type == interpreter.Flush {
				f.driver.Flush()
			} else if r.Type == interpreter.FetchAnswers {
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
