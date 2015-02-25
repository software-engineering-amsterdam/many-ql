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


%%

top:
	StylesheetToken TextToken '{' '}'
	{
		spew.Dump($$, $1, $2, $4)
	}
	;
