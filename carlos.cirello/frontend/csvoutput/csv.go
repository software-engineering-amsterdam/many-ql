// Package csvoutput is responsible for storing the result of a form in a CSV
// file from the runtime. It fulfills package frontend interface, therefore
// from package interpreter perspective, this is just another interface.
package csvoutput

import (
	"encoding/csv"
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/utils"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

type output struct {
	receive chan *plumbing.Frontend
	send    chan *plumbing.Frontend
	stream  io.Writer
}

// Write takes in a pair of channels for the interpreter, a writer stream and
// writes CSV output.
func Write(pipes *plumbing.Pipes, stream io.Writer) {
	output := &output{
		receive: pipes.FromInterpreter(),
		send:    pipes.ToInterpreter(),
		stream:  stream,
	}
	output.write()
}

func (o *output) write() {
	utils.OutputHandshake(o.receive, o.send)
	o.writeLines()
}

func (o *output) writeLines() {
	csv := csv.NewWriter(o.stream)
commLoop:
	for {
		select {
		case r := <-o.receive:
			switch r.Type {
			case plumbing.UpdateQuestion:
				csv.Write([]string{
					r.Identifier,
					r.Label,
					r.Value,
				})
			case plumbing.Flush:
				csv.Flush()
				break commLoop
			}
		}
	}
}
