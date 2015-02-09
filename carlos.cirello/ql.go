package main

import (
	"log"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/cli"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/compiler"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/output"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	inFn, outFn := cli.Args()

	// todo(carlos) extract CSV output into a proper module.
	outWriter := os.Stdout
	if outFn != "-" {
		file, err := os.Create(outFn)
		if err != nil {
			log.Fatalln("Error creating output file: ", err)
		}
		outWriter = file
	}
	csvWriter := output.New(outWriter)

	codeBuf, err := reader.New(inFn)
	if err != nil {
		log.Fatal(err)
	}
	code := codeBuf.Read()

	aQuestionaire := compiler.CompileQL(code)
	fromVM, toVM := vm.New(aQuestionaire)

	driver := graphic.GUI(aQuestionaire.Label)
	frontend.New(fromVM, toVM, driver)
	driver.Loop()
	csvWriter.Write(aQuestionaire)
}
