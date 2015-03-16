package main

import (
	"io"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func readInputCsv(pipes *plumbing.Pipes, inReader io.Reader) {
	if inReader == nil {
		return
	}
	csvinput.Read(pipes, inReader)
}

func writeOutputCsv(pipes *plumbing.Pipes, outWriter io.Writer) {
	csvoutput.Write(pipes, outWriter)
}

func errorHandler() {
	if r := recover(); r != nil {
		log.Println("error:", r)
	}
}

func startInterpreter(srcReader io.Reader, srcFn string) (
	pipes *plumbing.Pipes,
	guiAppName string,
) {
	aQuestionaire := parser.ReadQL(srcReader, srcFn)
	pipes = interpreter.New(aQuestionaire)
	guiAppName = aQuestionaire.Label()
	return pipes, guiAppName
}

func launchGUI(pipes *plumbing.Pipes, guiAppName string) {
	driver := graphic.GUI(guiAppName)
	frontend.New(pipes.FromInterpreter(), pipes.ToInterpreter(), driver)
	driver.Loop()
}
