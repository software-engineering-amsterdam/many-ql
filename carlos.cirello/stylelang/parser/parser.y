%{

package parser

import (
	"text/scanner"

	//"github.com/davecgh/go-spew/spew"
	"github.com/software-engineering-amsterdam/many-ql/carlos.cirello/stylelang/ast"
)

var finalStyle *ast.StyleNode
%}

%start top

%union {
	content string

	defaultNode *ast.DefaultNode
	stack []*ast.ActionNode
	styleNode *ast.StyleNode

	position scanner.Position
}

// Add tokens here must also lead to a lexer update at lexer.go
%token StylesheetToken
%token TextToken
%token NumericToken
%token QuotedStringToken
%token DefaultToken

%%

top:
	StylesheetToken TextToken '{' stack '}'
	{
		finalStyle = ast.NewStyleNode($2.content, $4.stack)
	}

stack:
	| stack defaultNode
	{
		d := $2.defaultNode
		qs := $$.stack
		action := ast.NewActionNode(d)
		qs = append(qs, action)
		$$.stack = qs
	}
	;

defaultNode:
	DefaultToken TextToken TextToken
	{
		$$.defaultNode = ast.NewDefaultNode($2.content, $3.content)
	}
	;
