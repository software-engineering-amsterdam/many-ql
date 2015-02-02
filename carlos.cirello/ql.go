package main

import (
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
)

func main() {
	aStringQuestion := question.StringQuestion("42")
	aQuestion := &question.Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: aStringQuestion,
	}

	aQuestionaire := &questionaire.Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*question.Question{
			aQuestion,
		},
	}

	aQuestionaire.PrettyPrintJson()
}
