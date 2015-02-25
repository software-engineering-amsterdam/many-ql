package parser

import (
	"strings"
	"testing"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
)

func TestParser(t *testing.T) {
	form := ReadQLS(
		strings.NewReader(`
		stylesheet SomeForm {}
		`),
		"test.ql",
	)
	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
	if form.Label() != "SomeForm" {
		t.Errorf("Form Name was not properly parsed")
		return
	}
}

func TestDefaults(t *testing.T) {
	form := ReadQLS(
		strings.NewReader(`
		stylesheet SomeForm {
			default boolean radio
			default boolean checkbox
		}
		`),
		"test.ql",
	)

	if form == nil {
		t.Errorf("Compilation should not return nil")
		return
	}
	stack := form.Stack()
	actionNode := stack[0].Action()
	if typ, ok := actionNode.(*ast.DefaultNode); !ok {
		t.Errorf("Expected a defaultNode. Got %T", typ)
		return
	}
}
