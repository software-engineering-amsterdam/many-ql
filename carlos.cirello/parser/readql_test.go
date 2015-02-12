package parser

import "testing"

func TestBasic(t *testing.T) {
	form := ReadQL(
		`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel2" question2 integer
			"QuestionLabel3" question3 bool
		}`,
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestComments(t *testing.T) {
	form := ReadQL(
		`form SomeForm {
			"QuestionLabel" question1 string
			//"QuestionLabel2" question2 integer
			/*"QuestionLabel3" question3 bool*/
		}`,
	)
	lenQ := len(form.Stack)
	if lenQ > 1 {
		t.Errorf("Comment should be ignore and not yield tokens. There should be 1 question, got %d.", lenQ)
	}
}
