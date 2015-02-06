package ast

import "testing"

func TestIntQuestion(t *testing.T) {
	expected := "42"

	aIntQuestion := new(IntQuestion)
	aIntQuestion.FromString(expected)

	if got := aIntQuestion.String(); expected != got {
		t.Errorf("Internal error in IntQuestion. Got %s, Expected %s",
			got, expected)
	}
}
