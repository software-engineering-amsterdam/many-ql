package parser

import (
	"strings"
	"testing"
)

func TestBasic(t *testing.T) {
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
}

func TestDefault(t *testing.T) {
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
}
