package csvinput

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/plumbing"
)

// Input holds an io.Reader which is used to transfer the responses of the form
// from a CSV file.
type Input struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend
	stream  io.Reader
}

// New takes in a pair of channels for the interpreter, a reader stream and
// prepare an object to be consumed later.
func New(fromInterpreter, toInterpreter chan *plumbing.Frontend,
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
	answers := i.readAnswers()
	i.handshake()
	i.sendAnswers(answers)
	i.handoverAndRedraw()
}

func (i *Input) readAnswers() (answers map[string]string) {
	csvReader := csv.NewReader(i.stream)
	answers = make(map[string]string)
	for {
		row, err := csvReader.Read()
		if err != nil {
			break
		}
		answers[row[0]] = row[2]
	}
	return answers
}

func (i *Input) handshake() {
	// handshake
	<-i.receive
	i.send <- &plumbing.Frontend{
		Type: plumbing.ReadyT,
	}

	// skip rendering
renderingSkipLoop:
	for {
		select {
		case r := <-i.receive:
			if r.Type == plumbing.Flush {
				break renderingSkipLoop
			}
		}
	}
}

func (i *Input) sendAnswers(answers map[string]string) {
	answerEvent := &plumbing.Frontend{
		Type:    plumbing.Answers,
		Answers: answers,
	}
commLoop:
	for {
		select {
		case <-i.receive:
		case i.send <- answerEvent:
			break commLoop

		default:

		}
	}
}

func (i *Input) handoverAndRedraw() {
	redrawEvent := &plumbing.Frontend{Type: plumbing.Redraw}
redrawLoop:
	for {
		select {
		case <-i.receive:

		case i.send <- redrawEvent:
			break redrawLoop

		default:

		}
	}
}
