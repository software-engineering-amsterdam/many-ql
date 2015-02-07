package compiler

import "testing"

func TestCompiler(t *testing.T) {
	form := CompileQL(
		`form SomeForm {
			"QuestionLabel" string
			"QuestionLabel2" integer
			"QuestionLabel3" bool
		}`,
	)
	t.Logf("%+v", form)
	for k, q := range form.Questions {
		t.Logf("Question %d: %+v", k, q)
	}
}
