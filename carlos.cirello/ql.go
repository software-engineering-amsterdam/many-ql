package main

import (
	"bufio"
	"flag"
	"log"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/compiler"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	frontendText "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/text"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/reader"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	frontendFlag := flag.String("frontend", "GUI", "GUI or text")
	filenameFlag := flag.String("source", "-", `QL code filename or "-" to read from stdin`)
	flag.Parse()

	codeBuf, err := reader.New(*filenameFlag)
	if err != nil {
		log.Fatal(err)
	}
	code := codeBuf.Read()

	aQuestionaire := compiler.CompileQL(code)
	fromVM, toVM := vm.New(aQuestionaire)

	var driver frontend.Inputer
	if *frontendFlag == "GUI" {
		graphic.GUI("GUI Form")
	} else {
		driver = frontendText.NewReader(
			bufio.NewReader(os.Stdin),
			os.Stdout,
		)
	}
	frontend.New(fromVM, toVM, driver)
}
