package main

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"

func main() {
	aStringQuestion := questionaire.StringQuestion("42")
	aQuestion := &questionaire.Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: aStringQuestion,
	}

	aQuestionaire := &questionaire.Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*questionaire.Question{
			aQuestion,
		},
	}

	aQuestionaire.PrettyPrintJson()
}
