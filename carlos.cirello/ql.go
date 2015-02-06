package main

import (
	"bufio"
	"flag"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	frontendText "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/text"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	frontendFlag := flag.String("frontend", "GUI", "GUI or text")
	flag.Parse()
	if *frontendFlag == "GUI" {
		graphic.GUI("GUI Form")
	} else {
		aQuestionaire := &ast.Questionaire{
			Label: "University of Amsterdam Revenue Service",
			Questions: []*ast.Question{
				&ast.Question{
					Label:   "What is the answer to life the universe and everything?",
					Content: new(ast.IntQuestion),
				},
				&ast.Question{
					Label:   "Who said the logic is the cement of our civilization with which we ascended from Chaos using reason as our guide?",
					Content: new(ast.StringQuestion),
				},
				&ast.Question{
					Label:   "Hungry-p",
					Content: new(ast.BoolQuestion),
				},
			},
		}

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
