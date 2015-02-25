package parser

import (
	"fmt"
	"io"
	"strings"
	"text/scanner"
)

// The parser expects the lexer to return 0 on EOF.
const eof = 0

const (
	// StylesheetTokenText - Reserved Word
	StylesheetTokenText = "stylesheet"
	// DefaultTokenText - Reserved Word
	DefaultTokenText = "default"

	singleQuotedChar  = `'`
	doubleQuotedChar  = `"`
	literalQuotedChar = "`"
)

type lexer struct {
	scanner scanner.Scanner

	pos scanner.Position
}

func newLexer(stream io.Reader, fn string) *lexer {
	var s scanner.Scanner
	s.Init(stream)
	s.Whitespace = 1<<'\t' | 1<<'\n' | 1<<'\r' | 1<<' '
	s.Filename = fn

	return &lexer{
		scanner: s,
	}
}

// The parser calls this method to get each new token.
func (x *lexer) Lex(yylval *qlsSymType) int {
	tok := x.scanner.Scan()

	if tok == scanner.EOF {
		return eof
	}

	txt := x.scanner.TokenText()
	// nextRune := string(x.scanner.Peek())
	typ := TextToken

	if tok == scanner.Float || tok == scanner.Int {
		typ = NumericToken
	} else if txt == StylesheetTokenText {
		typ = StylesheetToken
	} else if txt == DefaultTokenText {
		typ = DefaultToken

	} else if txt == "{" || txt == "}" || txt == "(" || txt == ")" ||
		txt == "+" || txt == "-" || txt == "*" || txt == "/" ||
		txt == "=" || txt == "!" {
		typ = int(txt[0])
	} else if strings.HasPrefix(txt, singleQuotedChar) ||
		strings.HasPrefix(txt, doubleQuotedChar) ||
		strings.HasPrefix(txt, literalQuotedChar) {
		typ = QuotedStringToken
		txt = stripSurroundingQuotes(txt)
	}

	yylval.content = txt
	yylval.position = x.scanner.Pos()

	x.pos = x.scanner.Pos()

	return typ
}

// The parser calls this method on a parse error.
func (x *lexer) Error(s string) {
	panic(fmt.Sprintf("%s:%d:%d:parse error: %s", x.pos.Filename, x.pos.Line, x.pos.Column, s))
}

func stripSurroundingQuotes(str string) string {
	return str[1 : len(str)-1]
}
