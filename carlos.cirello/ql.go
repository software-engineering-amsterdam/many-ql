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
	log.Println("Got code: ", code)
	aQuestionaire := compiler.CompileQL(code)
	log.Printf("%#v", aQuestionaire)

	if *frontendFlag == "GUI" {
		graphic.GUI("GUI Form")
	} else {
		toFrontend, fromFrontend := frontend.New(
			frontendText.NewReader(
				bufio.NewReader(os.Stdin),
				os.Stdout,
			),
		)

		vm.New(aQuestionaire, toFrontend, fromFrontend)
		// aQuestionaire.PrettyPrintJSON()

		// for _, question := range aQuestionaire.Questions {
		// 	textFE.InputQuestion(question)
		// }

		// aQuestionaire.PrettyPrintJSON()
	}
}
