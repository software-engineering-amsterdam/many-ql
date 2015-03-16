package interpreter

import (
	"bytes"
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvinput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/frontend/csvoutput"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/plumbing"
)

func TestRegressionComparison(t *testing.T) {
	runSuccessfulForm(t, `
		form SomeForm {
			if (1+1 == 2) {
				"15 - is 1+1=2?" questionEleven bool
			}
		}
	`)
}

func TestComparisonQuestionsAndConstants(t *testing.T) {
	form := `
	form SomeForm {
		"2 - What's the answer to life the universe and everything?"
		questionTwo   numeric

		if (questionTwo == 1) {
			"13 - (IF-ElseIf-Else) Question 2 is equals to 1?" questionTenAndHalfElseIf bool
		} else {
			"14 - (IF-ElseIf-Else) Question 2 is not equals to 0?" questionTenAndHalfElse bool
		}
	}
	`
	runSuccessfulFormWithIO(
		t,
		form,
		`questionTwo,desc,1`,
		`questionTwo,2 - What's the answer to life the universe and everything?,1`+"\n"+
			`questionTenAndHalfElseIf,13 - (IF-ElseIf-Else) Question 2 is equals to 1?,No`+"\n",
	)

	runSuccessfulFormWithIO(
		t,
		form,
		`questionTwo,desc,2`,
		`questionTwo,2 - What's the answer to life the universe and everything?,2`+"\n"+
			`questionTenAndHalfElse,14 - (IF-ElseIf-Else) Question 2 is not equals to 0?,No`+"\n",
	)
}

func TestComparisonBoolQuestions(t *testing.T) {
	form := `
	form SomeForm {
		"3 - True or false"
		questionThree   bool

		if (questionThree) {
			"True?" isTrue bool
		} else {
			"False?" isFalse bool
		}
	}
	`
	runSuccessfulFormWithIO(
		t,
		form,
		`questionThree,desc,Yes`,
		`questionThree,3 - True or false,Yes`+"\n"+
			`isTrue,True?,No`+"\n",
	)

	runSuccessfulFormWithIO(
		t,
		form,
		`questionThree,desc,No`,
		`questionThree,3 - True or false,No`+"\n"+
			`isFalse,False?,No`+"\n",
	)
}

func TestAdditionWrongTypes(t *testing.T) {
	form := `
	form SomeForm {
		"1 - Who said the logic is the cement of our civilization with which we ascended from chaos using reason as our guide?"
		questionOne   string

		"2 - What's the answer to life the universe and everything?"
		questionTwo   numeric

		"3 - Are you happy today?"
		questionThree bool

		"4 - Bad Question" questionTwentyTwo computed = questionOne + questionTwo
	}
	`
	runFormAndTrapError(t, form)
}

func TestInvalidQuestionType(t *testing.T) {
	form := `
	form SomeForm {
		"Invalid Question Type"
		questionOne   invalidType

		"Invalid Question Type 2"
		questionTwo   invalidType2
	}
	`
	runFormAndTrapError(t, form)
}

func TestDuplicatedLabel(t *testing.T) {
	form := `
	form SomeForm {
		"Invalid Question Type"
		questionOne   numeric

		"Invalid Question Type"
		questionTwo   numeric
	}
	`
	runSuccessfulForm(t, form)
}

func TestDuplicatedIdentifier(t *testing.T) {
	form := `
	form SomeForm {
		"Invalid Question Type"
		questionOne   numeric

		"Invalid Question Type"
		questionOne   numeric
	}
	`
	runFormAndTrapError(t, form)
}

func TestReservedWords(t *testing.T) {
	form := `
	form SomeForm {
		"q1" q1 bool

		if (q1 == true) {
			"q2" q2 string
		}
		if (q1) {
			"q3" q3 string
		}
	}
	`
	runSuccessfulFormWithIO(
		t,
		form,
		`q1,q1,Yes`,
		`q1,q1,Yes`+"\n"+
			`q2,q2,`+"\n"+
			`q3,q3,`+"\n",
	)
	runSuccessfulFormWithIO(
		t,
		form,
		`q1,q1,No`,
		`q1,q1,No`+"\n",
	)
}

func runFormAndTrapError(t *testing.T, source string) {
	defer func() {
		if r := recover(); r != nil {
			t.Log("Error captured. Got:", r)
		}
	}()

	runForm(source)
	t.Error("Interpreter should have failed.")
}

func runSuccessfulFormWithIO(t *testing.T, form, in, expected string) {
	pipes := runSuccessfulForm(t, form)
	sendCsv(pipes, in)
	got := readCsv(pipes)
	if expected != got {
		t.Errorf("Expected: %s. Got: %s", expected, got)
	}
}

func runSuccessfulForm(t *testing.T, source string) *plumbing.Pipes {
	defer func() {
		if r := recover(); r != nil {
			t.Error("Interpreter should not fail. Got:", r)
		}
	}()
	return runForm(source)
}

func runForm(source string) *plumbing.Pipes {
	form := parser.ReadQL(strings.NewReader(source), "test.ql")
	return New(form)
}

func sendCsv(pipes *plumbing.Pipes, str string) {
	csvinput.Read(pipes, strings.NewReader(str))
	unlockInterpreter(pipes)
}

func unlockInterpreter(pipes *plumbing.Pipes) {
	select {
	case r := <-pipes.FromInterpreter():
		switch r.Type {
		case plumbing.ReadyP:
			pipes.ToInterpreter() <- &plumbing.Frontend{
				Type: plumbing.ReadyT,
			}
		}
	}
}

func readCsv(pipes *plumbing.Pipes) string {
	var b bytes.Buffer
	csvoutput.Write(pipes, &b)
	return b.String()
}
