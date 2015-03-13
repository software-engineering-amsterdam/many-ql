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

	fromInterpreter, toInterpreter, guiAppName := startInterpreter(srcReader, srcFn)
	readInputCsv(fromInterpreter, toInterpreter, inReader)
	launchGUI(fromInterpreter, toInterpreter, guiAppName)

	csvWriter := csvoutput.New(fromInterpreter, toInterpreter, outWriter)
	csvWriter.Write()
}
