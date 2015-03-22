// Package jsoninput is responsible for reading the result of a form in CSV
// format into the runtime. It fulfills package frontend interface, therefore
// from package interpreter perspective, this is just another interface.
package jsoninput

import (
	"encoding/json"
	"fmt"
	"io"
	"io/ioutil"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/utils"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

type input struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend
	stream  io.Reader
}

// New takes in a pair of channels for the interpreter, a reader stream and
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

func (i *input) readAnswers() map[string]string {
	rows := i.unmarshalJSON()
	answers := i.convertRowsIntoAnswers(rows)

	return answers
}

func (i *input) unmarshalJSON() []map[string]string {
	var rows []map[string]string

	byt, err := ioutil.ReadAll(i.stream)
	if err != nil {
		panic(err)
	}
	if err := json.Unmarshal(byt, &rows); err != nil {
		panic(err)
	}

	return rows
}

func (i *input) convertRowsIntoAnswers(
	rows []map[string]string,
) map[string]string {
	answers := make(map[string]string)

	for idx, row := range rows {
		if !i.isWellformedRow(row) {
			panic(fmt.Sprintf(
				"malformed row %d",
				idx+1,
			))
		}
		answers[row["question"]] = row["value"]
	}

	return answers
}

func (i *input) isWellformedRow(row map[string]string) bool {
	_, okQuestion := row["question"]
	_, okValue := row["value"]
	return okQuestion && okValue
}
