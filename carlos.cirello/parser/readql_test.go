package parser

import (
	"strings"
	"testing"
)

func TestBasic(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel2" question2 integer
			"QuestionLabel3" question3 bool
		}`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestComments(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			//"QuestionLabel2" question2 integer
			/*"QuestionLabel3" question3 bool*/
		}`),
		"test.ql",
	)
	lenQ := len(form.Stack)
	if lenQ > 1 {
		t.Errorf("Comment should be ignore and not yield tokens. There should be 1 question, got %d.", lenQ)
	}
}

func TestIf(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel2" question2 integer
			"QuestionLabel3" question3 bool

			if (question3) {
				"Why are you happy today?" questionFour string
				"Grade your happiness?"    questionFive integer
			}
		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestIfConditions(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form ConditionsForm {
			if (1000) {}
			if (2000 == 3000) {}
			if (4000 == 5000) {}

			if (2000 > 3000) {}
			if (4000 < 5000) {}

			if (2000 >= 3000) {}
			if (4000 <= 5000) {}
		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestIfArithExpressions(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form Math {
			if(100){}
			if(100 + 200){}
			if(100 + 200 + 300){}
			if(100 + 200 + 300 * 400){}
		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestMultipleIfs(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form SomeForm {
			"QuestionLabel2" question2 integer
			"QuestionLabel3" question3 bool

			if (question3) {
				"Why are you happy today?" questionFour string
			}

			if (question2 > 5) {
				"Bigger than 5?" questionSix integer
			}

			if (question2 < 5) {
				"Smaller than 5?" questionSeven integer
				if (question2 < 3) {
					"Smaller than 3?" questionEight integer
					"Smaller than 2?" questionNine integer
				}
				if (question2 < 1) {
					"Smaller than 1?" questionTen integer
					"Smaller than 0?" questionEleven integer
				}
				"Why?" questionTwelve string
			}

		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestIfArithAndComparisonExpressions(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form Math {
			if(100 + 200 > 300){}
		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}
