package ast

import "testing"

func TestQuestionaire(t *testing.T) {
	aStringQuestion := StringQuestion("42")
	aQuestion := &Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: &aStringQuestion,
	}

	aQuestionaire := &Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*Question{
			aQuestion,
		},
	}

	aQuestionaire.PrettyPrintJSON()
}

func TestMultipleQuestions(t *testing.T) {
	aQuestionaire := &Questionaire{
		Label: "University of Amsterdam Revenue Service",
		Questions: []*Question{
			&Question{
				Label:   "What is the answer to life the universe and everything?",
				Content: new(IntQuestion),
			},
			&Question{
				Label:   "Who said the logic is the cement of our civilization with which we ascended from Chaos using reason as our guide?",
				Content: new(StringQuestion),
			},
			&Question{
				Label:   "Hungry-p",
				Content: new(BoolQuestion),
			},
		},
	}

	aQuestionaire.PrettyPrintJSON()
}
