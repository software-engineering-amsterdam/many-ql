grammar Calculator;
 
options {
    language=CSharp3;
}

@lexer::namespace{ANTLR_Test}
@parser::namespace{ANTLR_Test}

/*
 * Parser Rules
 */
 
addSubExpr
    : multDivExpr (( '+' | '-' ) multDivExpr)*
	;
 
multDivExpr
  : INT (( '*' | '/' ) INT)*;
 
/*
 * Lexer Rules
 */
 
INT : '0'..'9'+;
WS :  (' '|'\t'|'\r'|'\n')+ {Skip();} ;