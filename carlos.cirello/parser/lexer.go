package parser

import (
	"io"
	"log"
	"os"
	"strings"
	"text/scanner"
)

// The parser expects the lexer to return 0 on EOF.
const eof = 0

const (
	// FormTokenText - Reserved Word
	FormTokenText = "form"
	// IfTokenText - Reserved Word
	IfTokenText = "if"
	// StringQuestionTokenText - Reserved Word
	StringQuestionTokenText = "string"
	// IntQuestionTokenText - Reserved Word
	IntQuestionTokenText = "integer"
	// BoolQuestionTokenText - Reserved Word
	BoolQuestionTokenText = "bool"

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
func (x *lexer) Lex(yylval *qlSymType) int {
	tok := x.scanner.Scan()

	if tok == scanner.EOF {
		return eof
	}

	txt := x.scanner.TokenText()
	typ := TextToken

	if txt == FormTokenText {
		typ = FormToken
	} else if txt == StringQuestionTokenText {
		typ = StringQuestionToken
	} else if txt == IntQuestionTokenText {
		typ = IntQuestionToken
	} else if txt == BoolQuestionTokenText {
		typ = BoolQuestionToken
	} else if txt == IfTokenText {
		typ = IfToken
	} else if txt == "{" || txt == "}" || txt == "(" || txt == ")" {
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
	log.Printf("%s:%d:%d:parse error: %s", x.pos.Filename, x.pos.Line, x.pos.Column, s)
	os.Exit(1)
}

func stripSurroundingQuotes(str string) string {
	return str[1 : len(str)-1]
}
