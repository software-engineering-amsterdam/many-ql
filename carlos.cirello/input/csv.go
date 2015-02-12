package input

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
)

// Input holds an io.Reader which is used to transfer the responses of the form
// from a CSV file.
type Input struct {
	receive chan *interpreter.Event
	send    chan *interpreter.Event
	stream  io.Reader
}

// New takes in a pair of channels for the interpreter, a reader stream and
// prepare an object to be consumed later.
func New(fromInterpreter, toInterpreter chan *interpreter.Event,
	stream io.Reader) *Input {
	return &Input{
		receive: fromInterpreter,
		send:    toInterpreter,
		stream:  stream,
	}
}

// Write reads all questions from current state of the interpreter and writes to
// Input stream.
func (i *Input) Read() {
	csvReader := csv.NewReader(i.stream)
	answers := make(map[string]string)
	for {
		row, err := csvReader.Read()
		if err != nil {
			break
		}
		answers[row[0]] = row[2]
	}
	<-i.receive

	readyT := &interpreter.Event{
		Type: interpreter.ReadyT,
	}

commLoopReadyT:
	for {
		select {
		case <-i.receive:
		case i.send <- readyT:
			break commLoopReadyT
		}
	}

	sendAnswers := &interpreter.Event{
		Type:    interpreter.Answers,
		Answers: answers,
	}

commLoop:
	for {
		select {
		case <-i.receive:
		case i.send <- sendAnswers:
			break commLoop
		}
	}
}
