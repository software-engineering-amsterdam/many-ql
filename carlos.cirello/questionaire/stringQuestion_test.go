package questionaire

import "testing"

func TestStringQuestion(t *testing.T) {
	expected := "what is the answer to life the universe and everything?"

	aStringQuestion := new(StringQuestion)
	aStringQuestion.FromString(expected)

	if got := aStringQuestion.String(); expected != got {
		t.Errorf("Internal error in StringQuestion. Got %s, Expected %s", got, expected)
	}
}
