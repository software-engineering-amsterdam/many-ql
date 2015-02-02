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
