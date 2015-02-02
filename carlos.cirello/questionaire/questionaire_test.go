package questionaire

import (
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
)

func TestQuestionaire(t *testing.T) {
	aStringQuestion := question.StringQuestion("42")
	aQuestion := &question.Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: aStringQuestion,
	}

	aQuestionaire := &Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*question.Question{
			aQuestion,
		},
	}

	aQuestionaire.PrettyPrintJson()
}

func TestMultipleQuestions(t *testing.T) {
	aQuestionaire := &Questionaire{
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
}
