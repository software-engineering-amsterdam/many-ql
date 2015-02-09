%{

package compiler

import (
	"log"
	"strings"
	"text/scanner"

	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/ast"
)

var finalForm *ast.QuestionaireNode

//Top Ends Here
%}

%start top

%union {
	content string
	form *ast.QuestionaireNode
	stack []*ast.QuestionNode
	question *ast.QuestionNode
	questionType ast.Parser
}

%token BlockBeginToken
%token BlockEndToken
%token FormToken
%token IfToken
%token ParenBeginToken
%token ParenEndToken
%token QuotedStringToken
%token TextToken
%token StringQuestionToken
%token IntQuestionToken
%token BoolQuestionToken


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
	FormToken TextToken '{' stack '}'
	{
		if qlDebug > 0 {
			log.Println("Form: 1:", $1, "2:", $2, " 2c:", $2.content,
				" $$:", $$)
		}
		$$.form = &ast.QuestionaireNode{
			Label: $2.content,
			Stack: $4.stack,
		}
	}
	;

stack:
	| stack question
	{
		if qlDebug > 0 {
			log.Printf("Question*s*: 1:%#v 2:%#v $:%#v", $1.stack,
				$2.question, $$.stack)
		}
		q := $2.question
		qs := $$.stack
		qs = append(qs, q)
		$$.stack = qs
	}
	;

question:
	QuotedStringToken TextToken questionType
	{
		$$.question = &ast.QuestionNode{
			Label: $1.content,
			Identifier: $2.content,
			Content: $3.questionType,
		}

		if qlDebug > 0 {
			log.Printf("Question: 1:%+v 2:%+v 3:%+v, $:%+v", $1, $2, $3, $$)
		}
	}
	;

questionType: StringQuestionToken
		{
			$$.questionType = new(ast.StringQuestion)
		}
            | IntQuestionToken
		{
			$$.questionType = new(ast.IntQuestion)
		}
            | BoolQuestionToken
		{
			$$.questionType = new(ast.BoolQuestion)
		}
%%
// Bottom starts here
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

	return typ
}

// The parser calls this method on a parse error.
func (x *lexer) Error(s string) {
	log.Printf("parse error: %s", s)
}

// CompileQL generates a AST (*ast.Questionaire and children) out of source code.
func CompileQL(code string) *ast.QuestionaireNode {
	finalForm = nil
	qlParse(newLexer(code))
	return finalForm
}

func stripSurroundingQuotes(str string) string {
	return str[1:len(str)-1]
}