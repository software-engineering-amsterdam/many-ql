%{

package compiler

import (
	"log"
	"strings"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/question"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/questionaire"
)

var finalForm *questionaire.Questionaire

//Top Ends Here
%}

%start top

%union {
	content string
	form *questionaire.Questionaire
	questions []*question.Question
	question *question.Question
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
	form
	{
		if qlDebug > 0 {
			log.Printf("Top: %+v", $1.form)
		}
		finalForm = $1.form
	}
	;

form:
	FormToken TextToken BlockBeginToken questions BlockEndToken
	{
		if qlDebug > 0 {
			log.Println("Form: 1:", $1, "2:", $2, " 2c:", $2.content, " $$:", $$)
		}
		$$.form = &questionaire.Questionaire{
			Label: $2.content,
			Questions: $4.questions,
		}
	}
	;

questions:
	| questions question
	{
		if qlDebug > 0 {
			log.Printf("Question*s*: 1:%#v 2:%#v $:%#v", $1.questions, $2.question, $$.questions)
		}
		q := $2.question
		qs := $$.questions
		qs = append(qs, q)
		$$.questions = qs
	}
	;

question:
	QuotedStringToken TextToken
	{
		$$.question = &question.Question{
			Label: $1.content,
			Content: $2.content,
		}
		if qlDebug > 0 {
			log.Printf("Question: 1:%+v 2:%+v $:%+v", $1, $2, $$)
		}
	}
	;

%%
// Bottom starts here
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

func newLexer(code string) *lexer {
	var s scanner.Scanner
	s.Init(strings.NewReader(code))
	s.Whitespace = 1<<'\t' | 1<<'\n' | 1<<'\r' | 1<<' '

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
	} else if strings.HasPrefix(txt, BlockBeginTokenText) {
		typ = BlockBeginToken
	} else if strings.HasPrefix(txt, BlockEndTokenText) {
		typ = BlockEndToken
	} else if txt == IfTokenText {
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

func CompileQL(code string) *questionaire.Questionaire {
	finalForm = nil
	qlParse(newLexer(code))
	return finalForm
}