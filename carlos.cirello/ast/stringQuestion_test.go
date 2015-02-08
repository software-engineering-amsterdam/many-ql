package ast

import "testing"

func TestStringQuestion(t *testing.T) {
	input := "what is the answer to life the universe and everything?"

	aStringQuestion := new(StringQuestion)
	aStringQuestion.From(input)

	if got := aStringQuestion.String(); input != got {
		t.Errorf("Internal error in StringQuestion. Got %s, Expected %s",
			got, input)
	}
}
