//go:generate -command yacc go tool yacc
//go:generate yacc -o parser.go -p "ql" parser.y

/*
Package compiler uses native Go's yacc to parse the QL source code.
Internally, it uses a customized lexer to walk throughout the tokens
of the source code.
*/
package compiler
