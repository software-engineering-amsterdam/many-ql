// +build json

package main

import (
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/jsoninput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/jsonoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func readInput(pipes *plumbing.Pipes, inReader io.Reader) {
	if inReader == nil {
		return
	}
	jsoninput.Read(pipes, inReader)
}

func writeOutput(pipes *plumbing.Pipes, outWriter io.Writer) {
	jsonoutput.Write(pipes, outWriter)
}
