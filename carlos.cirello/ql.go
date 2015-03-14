// QL.
//
// Carlos Cirello - MSc. Software Engineering - Batch 2015/2016.
// Questionaire Language is a toy project for UvA Software Construction
// Course 2014/2015 Batch.
//
// It is a DSL meant to describe forms (QL).
package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
)

func main() {
	defer errorHandler()

	srcFn, inFn, outFn := cli.Args()
	srcReader, inReader, outWriter := iostream.Open(srcFn, inFn, outFn)

	pipes, guiAppName := startInterpreter(srcReader, srcFn)
	readInputCsv(pipes, inReader)
	launchGUI(pipes, guiAppName)
	writeOutputCsv(pipes, outWriter)
}
