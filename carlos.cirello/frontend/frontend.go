/*
Package frontend is the set of goroutines which interface with VM and the user.
The interface with the user can be either Graphic, Text or Web.
*/
package frontend

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"

// Inputer describes the actions which frontend must implement
// in order to be compliant with the VM expectations of
// functionality.
type Inputer interface {
	DrawQuestion(
		identifier,
		label,
		typ string,
		visible event.Visibility,
	)
	UpdateQuestion(
		identifier string,
		fieldType string,
		value interface{},
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
					r.Identifier,
					r.Label,
					r.FieldType,
					r.Visible,
				)

			case event.UpdateQuestion:
				f.driver.UpdateQuestion(r.Identifier,
					r.FieldType, r.Value)

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
