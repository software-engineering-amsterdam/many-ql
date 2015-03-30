package main

import (
	"io"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/iostream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func errorHandler() {
	if r := recover(); r != nil {
		log.Println("error:", r)
	}
}

func startInterpreter(srcReader io.Reader, srcFn string) (pipes *plumbing.Pipes,
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

func openIoStreams() (srcFn string, srcReader, inReader io.Reader,
	outWriter io.Writer) {
	srcFn, inFn, outFn := cli.Args()
	srcReader, inReader, outWriter = iostream.Open(srcFn, inFn, outFn)
	return srcFn, srcReader, inReader, outWriter
}
