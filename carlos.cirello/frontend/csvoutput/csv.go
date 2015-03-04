package csvoutput

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
)

// Output holds an io.Writer which is used to store the responses of the form
// (either into a file, or some other medium).
type Output struct {
	receive chan *event.Frontend
	send    chan *event.Frontend
	stream  io.Writer
}

// New takes in a pair of channels for the interpreter, a writer stream and
// prepare an object to be consumed later.
func New(fromInterpreter, toInterpreter chan *event.Frontend,
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
	o.handshake()
	o.writeLines()
}

func (o *Output) handshake() {
	readyT := &event.Frontend{
		Type: event.ReadyT,
	}

readyTLoop:
	for {
		select {
		case <-o.receive:
		case o.send <- readyT:
			break readyTLoop
		}
	}
}

func (o *Output) writeLines() {
	csv := csv.NewWriter(o.stream)
commLoop:
	for {
		select {
		case r := <-o.receive:
			switch r.Type {
			case event.UpdateQuestion:
				csv.Write([]string{r.Identifier, r.Label, r.Value})
			case event.Flush:
				csv.Flush()
				break commLoop
			}
		}
	}
}
