package ast

import "testing"

func testBoolQuestion(t *testing.T, input, output string) {
	q := new(BoolQuestion)
	q.From(input)

	if got := q.String(); output != got {
		t.Errorf("Internal error in BoolQuestion. Got %s, Expected %s",
			got, output)
	}

	if "bool" != q.Type() {
		t.Error("Bool questions should return a \"bool\" type")
	}
}

func TestBoolQuestion(t *testing.T) {
	testBoolQuestion(t, "1", "Yes")
	testBoolQuestion(t, "0", "No")
}
