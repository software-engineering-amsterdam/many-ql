//go:generate -command yacc go tool yacc
//go:generate yacc -o parser.go -p "ql" parser.y

/*
Package compiler uses native Go's yacc to parse the QL source code.
Internally, it uses a customized lexer to walk throughout the tokens
of the source code.
*/
package compiler

import "github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"

// CompileQL generates a AST (*ast.Questionaire and children) out of source code.
func CompileQL(code string) *ast.QuestionaireNode {
	finalQuestionaire = nil
	qlParse(newLexer(code))
	return finalQuestionaire
}
