package interpreter

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/parser"
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

func runSuccessfulForm(t *testing.T, str string) {
	defer func() {
		if r := recover(); r != nil {
			t.Error("Syntax should not fail. Got:", r)
		}
	}()
	form := parser.ReadQL(strings.NewReader(str), "test.ql")
	New(form)
}
