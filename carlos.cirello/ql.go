package main

import (
	"bufio"
	"flag"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/graphic"
	frontendText "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/text"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/vm"
)

func main() {
	frontendFlag := flag.String("frontend", "GUI", "GUI or text")
	flag.Parse()
	if *frontendFlag == "GUI" {
		graphic.GUI()
	} else {
		aQuestionaire := &questionaire.Questionaire{
			Label: "University of Amsterdam Revenue Service",
			Questions: []*question.Question{
				&question.Question{
					Label:   "What is the answer to life the universe and everything?",
					Content: new(question.IntQuestion),
				},
				&question.Question{
					Label:   "Who said the logic is the cement of our civilization with which we ascended from Chaos using reason as our guide?",
					Content: new(question.StringQuestion),
				},
				&question.Question{
					Label:   "Hungry-p",
					Content: new(question.BoolQuestion),
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
