package main

import (
	"io"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/plumbing"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/parser"
)

func readInputCsv(fromInterpreter, toInterpreter chan *plumbing.Frontend, inReader io.Reader) {
	if inReader == nil {
		return
	}
	csvReader := csvinput.New(fromInterpreter, toInterpreter, inReader)
	csvReader.Read()

}

func errorHandler() {
	if r := recover(); r != nil {
		log.Println("error:", r)
	}
}

func startInterpreter(srcReader io.Reader, srcFn string) (
	fromInterpreter,
	toInterpreter chan *plumbing.Frontend,
	guiAppName string,
) {
	aQuestionaire := parser.ReadQL(srcReader, srcFn)
	fromInterpreter, toInterpreter = interpreter.New(aQuestionaire)
	guiAppName = aQuestionaire.Label()
	return fromInterpreter, toInterpreter, guiAppName
}

func launchGUI(
	fromInterpreter,
	toInterpreter chan *plumbing.Frontend,
	guiAppName string,
) {
	driver := graphic.GUI(guiAppName)
	frontend.New(fromInterpreter, toInterpreter, driver)
	driver.Loop()
}
