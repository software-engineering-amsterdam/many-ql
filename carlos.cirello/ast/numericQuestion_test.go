package ast

import "testing"

func TestNumericQuestion(t *testing.T) {
	input := "42"

	q := new(NumericQuestion)
	q.From(input)

	if got := q.String(); input != got {
		t.Errorf("Internal error in IntQuestion. Got %s, Expected %s",
			got, input)
	}

	if v := q.Value(); 42 != v {
		t.Error("Error in parsing numbers for NumericQuestions. Expected 42. Got:", v)
	}

	if "numeric" != q.Type() {
		t.Error("Numeric questions should return a \"numeric\" type")
	}
}
