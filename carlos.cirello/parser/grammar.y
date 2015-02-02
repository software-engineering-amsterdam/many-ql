%{

package main

%}

%union {
	typ int
	val string
}


%token FormToken TextToken BlockBeginToken BlockEndToken IfToken ParenBeginToken ParenEndToken

%%
form: /* empty */
	| FormToken BlockBeginToken questions BlockEndToken
	;

questions:
	| questions question
	;

question:
	TextToken
	;