package ast

import "testing"

func TestIntQuestion(t *testing.T) {
	input := "42"

	aIntQuestion := new(IntQuestion)
	aIntQuestion.From(input)

	if got := aIntQuestion.String(); input != got {
		t.Errorf("Internal error in IntQuestion. Got %s, Expected %s",
			got, input)
	}
}
