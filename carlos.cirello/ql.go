package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
)

func main() {
	defer errorHandler()
	srcFn, inFn, outFn := cli.Args()

	srcReader, inReader, outWriter := iostream.New(srcFn, inFn, outFn)

	pipes, guiAppName := startInterpreter(srcReader, srcFn)
	readInputCsv(pipes, inReader)
	launchGUI(pipes, guiAppName)

	csvWriter := csvoutput.New(pipes, outWriter)
	csvWriter.Write()
}
