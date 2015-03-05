package main

import (
	"io"
	"log"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/interpreter/event"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/qlang/parser"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
	qlsparser "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/parser"
)

func loadStyle(styleReader io.Reader, srcFn string) map[string]*stylelang.Page {
	var theStyle *ast.StyleNode
	if styleReader != nil {
		theStyle = qlsparser.ReadQLS(styleReader, srcFn+"s")
	}
	vstr := ast.NewVisitor()
	vstr.Visit(theStyle)
	return vstr.Pages()
}

func readInputCsv(fromInterpreter, toInterpreter chan *event.Frontend, inReader io.Reader) {
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
	toInterpreter chan *event.Frontend,
	guiAppName string,
) {
	aQuestionaire := parser.ReadQL(srcReader, srcFn)
	fromInterpreter, toInterpreter = interpreter.New(aQuestionaire)
	guiAppName = aQuestionaire.Label()
	return fromInterpreter, toInterpreter, guiAppName
}

func launchGUI(
	fromInterpreter,
	toInterpreter chan *event.Frontend,
	guiAppName string,
	stylePages map[string]*stylelang.Page,
) {
	driver := graphic.GUI(guiAppName, stylePages)
	frontend.New(fromInterpreter, toInterpreter, driver)
	driver.Loop()
}
