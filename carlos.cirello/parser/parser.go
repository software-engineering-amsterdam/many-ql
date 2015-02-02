//go:generate -command yacc go tool yacc
//go:generate yacc -o grammar.go -p "grammar" grammar.y

// Package parser reads the token stream from lexer and parses into AST
package parser
