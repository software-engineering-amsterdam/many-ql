%{

package compiler

import (
	"log"
	"text/scanner"
	"strings"
)

%}

%union {
	content string
}

%token BlockBeginToken
%token BlockEndToken
%token FormToken
%token IfToken
%token ParenBeginToken
%token ParenEndToken
%token QuotedStringToken
%token TextToken

%%

top:
	question
	{
		log.Println($1)
	}

question:
	QuotedStringToken TextToken
	{
		log.Printf("I am in the parser: Question %s of type %s", $1, $2)
	}
	;

%%

// The parser expects the lexer to return 0 on EOF.
const eof = 0

const (
	// FormTokenText - Reserved Word
	FormTokenText = "form"
	// BlockBeginTokenText - Reserved Word
	BlockBeginTokenText = "{"
	// BlockEndTokenText - Reserved Word
	BlockEndTokenText = "}"
	// IfTokenText - Reserved Word
	IfTokenText = "if"
	// ParenBeginTokenText - Reserved Word
	ParenBeginTokenText = "("
	// ParenEndTokenText - Reserved Word
	ParenEndTokenText = ")"

	singleQuotedChar  = `'`
	doubleQuotedChar  = `"`
	literalQuotedChar = "`"
)

type lexer struct {
	scanner scanner.Scanner
}

func newLexer(code string) *lexer{
	var s scanner.Scanner
	s.Init(strings.NewReader(code))
	s.Whitespace = 1<<'\t' | 1<<'\r' | 1<<' '

	return &lexer{
		scanner: s,
	}
}

// The parser calls this method to get each new token.
func (x *lexer) Lex(yylval *qlSymType) int {
	tok := x.scanner.Scan()

	if tok == scanner.EOF {
		return eof;
	}

	txt := x.scanner.TokenText()
	typ := TextToken

	if strings.HasPrefix(txt, FormTokenText) {
		typ = FormToken
	} else if strings.HasPrefix(txt, BlockBeginTokenText) {
		typ = BlockBeginToken
	} else if strings.HasPrefix(txt, BlockEndTokenText) {
		typ = BlockEndToken
	} else if strings.HasPrefix(txt, IfTokenText) {
		typ = IfToken
	} else if strings.HasPrefix(txt, ParenBeginTokenText) {
		typ = ParenBeginToken
	} else if strings.HasPrefix(txt, ParenEndTokenText) {
		typ = ParenEndToken
	} else if strings.HasPrefix(txt, singleQuotedChar) || strings.HasPrefix(txt, doubleQuotedChar) || strings.HasPrefix(txt, literalQuotedChar) {
		typ = QuotedStringToken
	}

	yylval.content = txt

	return typ
}

// The parser calls this method on a parse error.
func (x *lexer) Error(s string) {
	log.Printf("parse error: %s", s)
}

