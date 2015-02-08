package compiler

import "testing"

func TestCompiler(t *testing.T) {
	form := CompileQL(
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
	t.Logf("%+v", form)
	for k, q := range form.Questions {
		t.Logf("Question %d: %+v", k, q)
	}
}
