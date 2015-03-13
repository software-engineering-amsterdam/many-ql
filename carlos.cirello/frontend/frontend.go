/*
Package frontend is the set of goroutines which interface with VM and the user.
The interface with the user can be either Graphic, Text or Web.
*/
package frontend

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	DrawQuestion(identifier, label, typ string, visible plumbing.Visibility)
	UpdateQuestion(identifier string, value interface{})
	Loop()
	Flush()
	FetchAnswers() map[string]string
}

type frontend struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend

	driver Inputer
}

// New instantiates a frontend goroutine, looping all the
// communications with the VM into the chosen Frontend
// (GUI, Text, Web).
func New(fromInterpreter, toInterpreter chan *plumbing.Frontend, driver Inputer) {
	f := &frontend{
		receive: fromInterpreter,
		send:    toInterpreter,
		driver:  driver,
	}

	go f.loop()
}

func (f *frontend) loop() {
	for {
		select {
		case r := <-f.receive:
			switch r.Type {
			case plumbing.ReadyP:
				f.send <- &plumbing.Frontend{
					Type: plumbing.ReadyT,
				}

			case plumbing.DrawQuestion:
				f.driver.DrawQuestion(
					r.Identifier,
					r.Label,
					r.FieldType,
					r.Visible,
				)

			case plumbing.UpdateQuestion:
				f.driver.UpdateQuestion(r.Identifier, r.Value)

			case plumbing.Flush:
				f.driver.Flush()

			case plumbing.FetchAnswers:
				fetchedAnswers := f.driver.FetchAnswers()
				if len(fetchedAnswers) > 0 {
					f.send <- &plumbing.Frontend{
						Type:    plumbing.Answers,
						Answers: fetchedAnswers,
					}
				}
			}
		default:
			//noop
		}
	}
}
