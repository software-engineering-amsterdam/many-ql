package ast

import "testing"

func TestQuestion(t *testing.T) {
	aStringQuestion := StringQuestion("42")
	aQuestion := &QuestionNode{
		label:   "what's the answer to life the universe and everything?",
		content: &aStringQuestion,
	}

	content := aQuestion.Content()
	switch questionType := content.(type) {
	case *StringQuestion:
	default:
		t.Errorf("Error with content type. Got %T. Expected StringQuestion",
			questionType)
	}

}
