// Package csvinput is responsible for reading the result of a form in CSV
// format into the runtime. It fulfills package frontend interface, therefore
// from package interpreter perspective, this is just another interface.
package csvinput

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/utils"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

type input struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend
	stream  io.Reader
}

// Read takes in a pair of channels for the interpreter, a reader stream and
// reads the input file content.
func Read(pipes *plumbing.Pipes, stream io.Reader) {
	input := &input{
		receive: pipes.FromInterpreter(),
		send:    pipes.ToInterpreter(),
		stream:  stream,
	}
	input.read()
}

func (i *input) read() {
	answers := i.readAnswers()
	utils.DispatchReadAnswers(answers, i.receive, i.send)
}

func (i *input) readAnswers() (answers map[string]string) {
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
