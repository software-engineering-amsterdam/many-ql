grammar QL;

@header {
package nl.uva.softwcons.generated;
}

/* Parser */
form:   'form' ID '{' statement+ '}';

statement: question
	|      conditional
	;

question: ID ':' STRING type                                 # simpleQuestion
    |     ID ':' STRING type '(' expr ')'                    # computedQuestion
    ;

conditional: 'if' '(' expr ')' '{' question+ '}'
	;

type: BOOL_TYPE        # booleanType
	| STRING_TYPE      # stringType
    | INT_TYPE         # intType
    | DATE_TYPE        # dateType
    | DECIMAL_TYPE     # decimalType
	| MONEY_TYPE       # moneyType
	;


expr:   expr (MUL|DIV) expr                         # mulDiv
    |   expr (ADD|SUB) expr                         # addSub
    |   expr (GT|GEq|LT|LEq|Eq|NEq) expr            # compare
    |   NOT expr                                    # not
    |   expr (AND) expr                             # and
    |   expr (OR) expr                              # or
    |   '(' expr ')'                                # parenthesis
    |   BOOLEAN                                     # boolean
    |   INT                                         # integer
    |   STRING                                      # string
    |   ID                                          # id
    ;

    
/* Lexer */
// Types
BOOL_TYPE : 'boolean' ;
STRING_TYPE : 'string' ;
INT_TYPE : 'integer' ;
DATE_TYPE    : 'date' ;
DECIMAL_TYPE : 'decimal' ;
MONEY_TYPE   : 'money' ;


// Basic arithmetic 
MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;

// Booleans
NOT :   '!' ;
AND :   '&&' ;
OR :   	'||' ;

// Comparisons
LT  :   '<'  ; 
LEq	:	'<=' ;
GT	:	'>' ;
GEq	:	'>=' ;
Eq  :	'==' ;
NEq :	'!=' ;

// Booleans
BOOLEAN  :  'true'|'false';

// Conditionals
IF   :   'if' ;

// Identifiers
ID  :   [a-zA-Z][a-zA-Z0-9]*;

// Numbers
INT :   [0-9]+ ;

// Strings
STRING : '"' ~["\r\n]* '"';

// Comments
COMMENT: '//' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT:  '/*' .*? '*/' -> skip;

// Whitespace
WS  :  [ \n\t\r]+ -> skip;
