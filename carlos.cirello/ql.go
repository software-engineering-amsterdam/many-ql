package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/stream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/compiler"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/interpreter"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/output"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
)

func main() {
	inFn, outFn := cli.Args()

	inReader, outWriter := stream.New(inFn, outFn)

	csvWriter := output.New(outWriter)
	codeBuf := reader.New(inReader)

	code := codeBuf.Read()
	aQuestionaire := compiler.CompileQL(code)
	fromInterpreter, toInterpreter := interpreter.New(aQuestionaire)

	driver := graphic.GUI(aQuestionaire.Label)
	frontend.New(fromInterpreter, toInterpreter, driver)
	driver.Loop()

	csvWriter.Write(aQuestionaire)
}
