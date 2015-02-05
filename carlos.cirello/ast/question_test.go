package ast

import "testing"

func TestQuestion(t *testing.T) {
	aStringQuestion := StringQuestion("42")
	aQuestion := &Question{
		Label:   "what's the answer to life the universe and everything?",
		Content: aStringQuestion,
	}

	switch questionType := aQuestion.Content.(type) {
	default:
		t.Errorf("Error with content type. Got %T. Expected StringQuestion", questionType)
	case StringQuestion:
	}

}
