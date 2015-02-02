package main

import (
	"bufio"
	"os"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/textFrontend"
)

func main() {
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

	aQuestionaire.PrettyPrintJson()

	textFE := textFrontend.NewReader(
		bufio.NewReader(os.Stdin),
		os.Stdout,
	)

	for _, question := range aQuestionaire.Questions {
		textFE.InputQuestion(question)
	}

	aQuestionaire.PrettyPrintJson()
}
