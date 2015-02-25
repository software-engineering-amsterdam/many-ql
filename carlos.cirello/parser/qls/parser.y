%{

package parser

import (
	"text/scanner"

	"github.com/davecgh/go-spew/spew"
)

var finalStyle interface{}
%}

%start top

%union {
	content string

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
		spew.Dump("top", $$, $1, $2, $4)
	}

stack:
	| stack defaultSetting
	{
		spew.Dump("stack", $$, $1, $2)
	}
	;

defaultSetting:
	DefaultToken TextToken TextToken
	{
		spew.Dump("defaultSetting", $$, $1, $2)
	}
	;
