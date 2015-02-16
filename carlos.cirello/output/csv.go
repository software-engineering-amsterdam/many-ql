package output

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
)

// Output holds an io.Writer which is used to store the responses of the form
// (either into a file, or some other medium).
type Output struct {
	receive chan *interpreter.Event
	send    chan *interpreter.Event
	stream  io.Writer
}

// New takes in a pair of channels for the interpreter, a writer stream and
// prepare an object to be consumed later.
func New(fromInterpreter, toInterpreter chan *interpreter.Event,
	stream io.Writer) *Output {
	return &Output{
		receive: fromInterpreter,
		send:    toInterpreter,
		stream:  stream,
	}
}

// Write reads all questions from current state of the interpreter and writes to
// output stream.
func (o *Output) Write() {
	csv := csv.NewWriter(o.stream)
	o.send <- &interpreter.Event{
		Type: interpreter.ReadyT,
	}

commLoop:
	for {
		select {
		case r := <-o.receive:
			switch r.Type {
			case interpreter.Render:
				v := r.Question
				csv.Write([]string{v.Identifier, v.Label, v.Content.String()})
			case interpreter.Flush:
				csv.Flush()
				break commLoop
			}
		}
	}
}
