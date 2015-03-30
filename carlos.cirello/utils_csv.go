// +build !json

package main

import (
	"io"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func readInput(pipes *plumbing.Pipes, inReader io.Reader) {
	if inReader == nil {
		return
	}
	csvinput.Read(pipes, inReader)
}

func writeOutput(pipes *plumbing.Pipes, outWriter io.Writer) {
	csvoutput.Write(pipes, outWriter)
}
