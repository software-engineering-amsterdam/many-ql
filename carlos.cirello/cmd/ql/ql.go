package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/cli/iostream"
)

func main() {
	defer errorHandler()
	srcFn, inFn, outFn := cli.Args()

	srcReader, styleReader, inReader, outWriter := iostream.New(srcFn, inFn, outFn)

	fromInterpreter, toInterpreter, guiAppName := startInterpreter(srcReader, srcFn)
	readInputCsv(fromInterpreter, toInterpreter, inReader)
	stylePages, questionsIndex := loadStyle(styleReader, srcFn)
	launchGUI(fromInterpreter, toInterpreter, guiAppName, stylePages, questionsIndex)

	csvWriter := csvoutput.New(fromInterpreter, toInterpreter, outWriter)
	csvWriter.Write()
}
