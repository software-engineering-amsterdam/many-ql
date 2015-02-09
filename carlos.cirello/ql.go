package main

import (
	"encoding/csv"
	"flag"
	"log"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/compiler"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	// todo(carlos) extract param parsing into a proper CLI module
	filenameFlag := flag.String("source", "-", `QL code filename or "-" to read from stdin`)
	flag.Parse()

	codeBuf, err := reader.New(*filenameFlag)
	if err != nil {
		log.Fatal(err)
	}
	code := codeBuf.Read()

	aQuestionaire := compiler.CompileQL(code)
	fromVM, toVM := vm.New(aQuestionaire)

	driver := graphic.GUI(aQuestionaire.Label)
	frontend.New(fromVM, toVM, driver)
	driver.Loop()

	// todo(carlos) extract CSV output into a proper module.
	csv := csv.NewWriter(os.Stdout)
	for _, v := range aQuestionaire.Questions {
		csv.Write([]string{v.Identifier, v.Label, v.Content.String()})
	}
	csv.Flush()
}
