package questionaire

import "testing"

func TestQuestionaire(t *testing.T) {
	aStringQuestion := StringQuestion("42")
	aQuestion := &Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: aStringQuestion,
	}

	aQuestionaire := &Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*Question{
			aQuestion,
		},
	}

	aQuestionaire.PrettyPrintJson()
}
