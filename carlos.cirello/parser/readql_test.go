package parser

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

func TestBasic(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel2" question2 numeric
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
			//"QuestionLabel2" question2 numeric
			/*"QuestionLabel3" question3 bool*/
		}`),
		"test.ql",
	)
	lenQ := len(form.Stack())
	if lenQ > 1 {
		t.Errorf("Comment should be ignore and not yield tokens. There should be 1 question, got %d.", lenQ)
	}
}

func TestIf(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form SomeForm {
			"QuestionLabel" question1 string
			"QuestionLabel2" question2 numeric
			"QuestionLabel3" question3 bool

			if (question3) {
				"Why are you happy today?" questionFour string
				"Grade your happiness?"    questionFive numeric
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
			"QuestionLabel2" question2 numeric
			"QuestionLabel3" question3 bool

			if (question3) {
				"Why are you happy today?" questionFour string
			}

			if (question2 > 5) {
				"Bigger than 5?" questionSix numeric
			}

			if (question2 < 5) {
				"Smaller than 5?" questionSeven numeric
				if (question2 < 3) {
					"Smaller than 3?" questionEight numeric
					"Smaller than 2?" questionNine numeric
				}
				if (question2 < 1) {
					"Smaller than 1?" questionTen numeric
					"Smaller than 0?" questionEleven numeric
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

func TestCalculatedQuestion(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form CalculatedFields {
			"Question 1" QuestionA numeric

			"Question Calculated"
			questionThree computed = questionA * 2
		}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}

func TestIfElseConditions(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form ConditionsForm {
			"QuestionLabel3" question3 bool
			"QuestionLabel4" question4 bool
			"QuestionLabel5" question5 bool

			if (question3) {
				"QuestionIfTrue" secondIfTrue string
				"QuestionIfTrue2" secondIfTrue2 string
			} else if (question4) {
				"QuestionIfTrue" secondIfTrue string
				"QuestionIfTrue2" secondIfTrue2 string
			} else if (question5) {
				"QuestionIfTrue" thirdIfTrue string
				"QuestionIfTrue2" thirdIfTrue2 string
			}

			if (question3) {
				"QuestionIfTrue" questionIfTrue string
				"QuestionIfTrue2" questionIfTrue3 string
			} else {
				"QuestionIfFalse" questionIfFalse string
				"QuestionIfFalse2" questionIfFalse2 string
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

func TestNegation(t *testing.T) {
	form := ReadQL(
		strings.NewReader(`
		form SomeForm {
			"Question 1" questionOne string
			"Question 2" questionTwo numeric

			if (!(questionOne == "string" and questionTwo == 42)) {
				"NegationBlock" computedQuestion computed = questionTwo * 2
			}
		}
		`),
		"test.ql",
	)
	rootCondition := form.Stack()[2].Action().(*ast.IfNode).Conditions()
	if got, ok := rootCondition.(*ast.BoolNegNode); !ok {
		t.Errorf("severe grammar error: expected BoolNegNode. got: %T", got)
	}

	firstChild := rootCondition.(*ast.BoolNegNode).SingleTermNode.Term()
	if got, ok := firstChild.(*ast.BoolAndNode); !ok {
		t.Errorf("severe grammar error: expected BoolAndNode. got: %T", got)
	}

	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
}
