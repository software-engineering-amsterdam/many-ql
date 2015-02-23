package ast

import "testing"

func TestStringQuestion(t *testing.T) {
	input := "what is the answer to life the universe and everything?"

	q := new(StringQuestion)
	q.From(input)

	if got := q.String(); input != got {
		t.Errorf("Internal error in StringQuestion. Got %s, Expected %s",
			got, input)
	}

	if "string" != q.Type() {
		t.Error("String questions should return a \"string\" type")
	}
}
