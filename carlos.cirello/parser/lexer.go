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
	// FormTokenText - Reserved Word.
	FormTokenText = "form"
	// IfTokenText - Reserved Word.
	IfTokenText = "if"
	// ElseTokenText - Reserved Word.
	ElseTokenText = "else"
	// ComputedQuestionTokenText - Reserved Word.
	ComputedQuestionTokenText = "computed"
	// BoolAndTokenText - Reserved Word.
	BoolAndTokenText = "and"
	// BoolOrTokenText - Reserved Word.
	BoolOrTokenText = "or"
	// BoolTrueTokenText - Reserved Word.
	BoolTrueTokenText = "true"
	// BoolFalseTokenText - Reserved Word.
	BoolFalseTokenText = "false"

	// LessThanTokenText - Reserved Symbols.
	LessThanTokenText = `<`
	// LessOrEqualsThanTokenText - Reserved Symbols.
	LessOrEqualsThanTokenText = `<=`
	// MoreThanTokenText - Reserved Symbols.
	MoreThanTokenText = `>`
	// MoreOrEqualsThanTokenText - Reserved Symbols.
	MoreOrEqualsThanTokenText = `>=`
	// EqualsToTokenText - Reserved Symbols.
	EqualsToTokenText = `==`
	// NotEqualsToTokenText - Reserved Symbols.
	NotEqualsToTokenText = `!=`

	// LikeTokenText - Reserved Symbols.
	LikeTokenText = `like`

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
	nextRune := string(x.scanner.Peek())
	txtAhead := txt + nextRune
	typ := TextToken

	if tok == scanner.Float || tok == scanner.Int {
		typ = NumericToken
	} else if txt == FormTokenText {
		typ = FormToken
	} else if txt == ComputedQuestionTokenText {
		typ = ComputedQuestionToken
	} else if txt == BoolAndTokenText {
		typ = BoolAndToken
	} else if txt == BoolOrTokenText {
		typ = BoolOrToken
	} else if txt == BoolTrueTokenText {
		typ = BoolTrueToken
	} else if txt == BoolFalseTokenText {
		typ = BoolFalseToken
	} else if txt == IfTokenText {
		typ = IfToken
	} else if txt == ElseTokenText {
		typ = ElseToken
	} else if txt == LikeTokenText {
		typ = LikeToken
	} else if txtAhead == LessOrEqualsThanTokenText {
		x.scanner.Scan()
		typ = LessOrEqualsThanToken
		txt = LessOrEqualsThanTokenText
	} else if txtAhead == MoreOrEqualsThanTokenText {
		x.scanner.Scan()
		typ = MoreOrEqualsThanToken
		txt = MoreOrEqualsThanTokenText
	} else if txtAhead == EqualsToTokenText {
		x.scanner.Scan()
		typ = EqualsToToken
		txt = EqualsToTokenText
	} else if txtAhead == NotEqualsToTokenText {
		x.scanner.Scan()
		typ = NotEqualsToToken
		txt = NotEqualsToTokenText
	} else if txt == MoreThanTokenText {
		typ = MoreThanToken
	} else if txt == LessThanTokenText {
		typ = LessThanToken
	} else if txt == "{" || txt == "}" || txt == "(" || txt == ")" ||
		txt == "+" || txt == "-" || txt == "*" || txt == "/" ||
		txt == "=" || txt == "!" || txt == "." || txt == "%" {
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
	panic(fmt.Sprintf("%s:parse error: %s", x.pos, s))
}

func stripSurroundingQuotes(str string) string {
	return str[1 : len(str)-1]
}
