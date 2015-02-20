package csvinput

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter/event"
)

// Input holds an io.Reader which is used to transfer the responses of the form
// from a CSV file.
type Input struct {
	receive chan *event.Event
	send    chan *event.Event
	stream  io.Reader
}

// New takes in a pair of channels for the interpreter, a reader stream and
// prepare an object to be consumed later.
func New(fromInterpreter, toInterpreter chan *event.Event,
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

	readyT := &event.Event{
		Type: event.ReadyT,
	}

commLoopReadyT:
	for {
		select {
		case <-i.receive:
		case i.send <- readyT:
			break commLoopReadyT
		}
	}

	sendAnswers := &event.Event{
		Type:    event.Answers,
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
