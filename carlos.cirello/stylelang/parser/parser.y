%{

package parser

import (
	"text/scanner"

	// "github.com/davecgh/go-spew/spew"
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
	pageNode *ast.PageNode

	position scanner.Position
}

// Add tokens here must also lead to a lexer update at lexer.go
%token DefaultToken
%token NumericToken
%token PageToken
%token QuotedStringToken
%token StylesheetToken
%token TextToken

%%

top:
	StylesheetToken TextToken '{' stack '}'
	{
		finalStyle = ast.NewStyleNode($4.stack)
		$4.stack = nil
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
	| stack page
	{
		d := $2.pageNode
		qs := $$.stack
		action := ast.NewActionNode(d)
		qs = append(qs, action)
		$$.stack = qs
	}
	| stack TextToken
	{
		qs := $$.stack
		action := ast.NewActionNode(ast.NewQuestionNode($2.content))
		qs = append(qs, action)
		$$.stack = qs
	}
	;

page:
	PageToken QuotedStringToken '{' stack '}'
	{
		$$.pageNode = ast.NewPageNode($2.content, $4.stack)
		$4.stack = nil
	}
	;

defaultNode:
	DefaultToken TextToken TextToken
	{
		$$.defaultNode = ast.NewDefaultNode($2.content, $3.content)
	}
	;
