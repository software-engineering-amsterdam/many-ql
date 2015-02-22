package typecheck

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
)

func TestDuplicatedIdentifier(t *testing.T) {
	form := parser.ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel" question1 string
		}`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if err := st.Err(); err == nil {
		t.Errorf("Typecheck error: duplicated identifiers should trigger error")
	}
}

// todo(carlos) TestDuplicatedIdentifierInIfBlocks
func TestDuplicatedIdentifierInIfBlocks(t *testing.T) {
	form := parser.ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 bool
			if (question1){
				"QuestionLabel2 - True" question2 string
			}
			if (!question1){
				"QuestionLabel2 - False" question2 string
			}
		}`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if err := st.Err(); err == nil {
		t.Errorf("Typecheck error: duplicated identifiers should trigger error")
	}
}

func TestDuplicatedIdentifierDifferentTypes(t *testing.T) {
	form := parser.ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel" question1 numeric
		}`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if err := st.Err(); err == nil {
		t.Errorf("Typecheck error: duplicated identifiers should trigger error, even with different types")
	}
}

func TestInvalidOperands(t *testing.T) {
	defer func() {
		recover()
	}()
	form := parser.ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			if (question1 + "string"){}
		}`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if err := st.Err(); err == nil {
		t.Errorf("Typecheck error: invalid operations should trigger error")
	}
}

func TestCyclicDependencies(t *testing.T) {
	defer func() {
		recover()
	}()
	form := parser.ReadQL(
		strings.NewReader(`
		form SomeForm {
			"QuestionLabel" question1 string

			if(question3){
				"question2" question2 bool
			}

			if(question2){
				"question3" question3 bool
			}
		}
		`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if err := st.Err(); err == nil {
		t.Errorf("Typecheck error: cyclic dependencies should trigger error")
	}
}

func TestRepeatedCaptions(t *testing.T) {
	form := parser.ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel" question2 numeric
		}`),
		"test.ql",
	)
	tc, st := New()
	tc.Visit(form)
	if warn := st.Warn(); warn == nil {
		t.Errorf("Typecheck error: duplicated captions should trigger warnings")
	}
}
