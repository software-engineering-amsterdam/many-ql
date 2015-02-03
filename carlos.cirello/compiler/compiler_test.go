package compiler

import "testing"

func TestCompiler(t *testing.T) {
	qlParse(newLexer(`"question" type`))
}
