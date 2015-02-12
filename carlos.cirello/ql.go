package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/stream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/input"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/output"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
)

func main() {
	srcFn, inFn, outFn := cli.Args()

	srcReader, inReader, outWriter := stream.New(srcFn, inFn, outFn)
	codeBuf := reader.New(srcReader)

	code := codeBuf.Read()
	aQuestionaire := parser.ReadQL(code)
	fromInterpreter, toInterpreter := interpreter.New(aQuestionaire)

	if inReader != nil {
		csvReader := input.New(fromInterpreter, toInterpreter, inReader)
		csvReader.Read()
	}

	driver := graphic.GUI(aQuestionaire.Label)
	frontend.New(fromInterpreter, toInterpreter, driver)
	driver.Loop()

	csvWriter := output.New(fromInterpreter, toInterpreter, outWriter)
	csvWriter.Write()
}
