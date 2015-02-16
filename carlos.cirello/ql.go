package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli/stream"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/compiler"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/output"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	inFn, outFn := cli.Args()

	inReader, outWriter := stream.New(inFn, outFn)

	csvWriter := output.New(outWriter)
	codeBuf := reader.New(inReader)

	code := codeBuf.Read()
	aQuestionaire := compiler.CompileQL(code)
	fromVM, toVM := vm.New(aQuestionaire)

	driver := graphic.GUI(aQuestionaire.Label)
	frontend.New(fromVM, toVM, driver)
	driver.Loop()

	csvWriter.Write(aQuestionaire)
}
