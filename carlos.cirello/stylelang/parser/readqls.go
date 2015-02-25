//go:generate -command yacc go tool yacc
//go:generate yacc -o parser.go -p "qls" parser.y

/*
Package parser uses native Go's yacc to parse the QLS source code.
Internally, it uses a customized lexer to walk throughout the tokens
of the source code.
*/
package parser

import "io"

// ReadQLS generates an AST out of source code.
func ReadQLS(stream io.Reader, fn string) interface{} {
	finalStyle = nil
	qlsParse(newLexer(stream, fn))
	return finalStyle
}
