/*
Package frontend is the set of goroutines which interface with VM and the user.
The interface with the user can be either Graphic, Text or Web.
*/
package frontend

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	InputQuestion(q *ast.Question)
	Loop()
	Flush()
	FetchAnswers() map[string]string
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fromVM, toVM chan *Event, driver Inputer) {
	f := &frontend{
		receive: fromVM,
		send:    toVM,
		driver:  driver,
	}

	go f.loop()
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
			if r.Type == ReadyP {
				f.send <- &Event{
					Type: ReadyT,
				}
			} else if r.Type == Render {
				f.driver.InputQuestion(&r.Question)
			} else if r.Type == Flush {
				f.driver.Flush()
			} else if r.Type == FetchAnswers {
				fetchedAnswers := f.driver.FetchAnswers()
				f.send <- &Event{
					Type:    Answers,
					Answers: fetchedAnswers,
				}
			}
		default:
			//noop
		}
	}
}
