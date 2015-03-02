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

type: BOOL_TYPE
    | STRING_TYPE
    | INT_TYPE
    | DATE_TYPE
    | DECIMAL_TYPE
    ;


expr: expr op=(MUL|DIV) expr                      # binaryExpr
    | expr op=(ADD|SUB) expr                      # binaryExpr
    | expr op=(GT|GEq|LT|LEq|Eq|NEq) expr         # binaryExpr
    | op=NOT expr                                 # notExpr
    | expr op=AND expr                            # binaryExpr
    | expr op=OR expr                             # binaryExpr
    | '(' expr ')'                                # parenthesis
    | BOOLEAN                                     # boolean
    | DECIMAL                                     # decimal 
    | INT                                         # integer
    | STRING                                      # string
    | ID                                          # id
    ;


/* Lexer */
// Types
BOOL_TYPE    : 'boolean' ;
STRING_TYPE  : 'string' ;
INT_TYPE     : 'integer' ;
DATE_TYPE    : 'date' ;
DECIMAL_TYPE : 'decimal' ;
MONEY_TYPE   : 'money' ;


// Basic arithmetic 
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;

// Booleans
NOT : '!' ;
AND : '&&' ;
OR  : '||' ;

// Comparisons
LT  : '<'  ; 
LEq : '<=' ;
GT  : '>' ;
GEq : '>=' ;
Eq  : '==' ;
NEq : '!=' ;

// Booleans
BOOLEAN : 'true'|'false';

// Conditionals
IF : 'if' ;

// Identifiers
ID : [a-zA-Z][a-zA-Z0-9]*;

// Numbers, stolen from JSON.g4 in antlr/grammars-v4/ repository
INT : '-'? INT_FRAG;

DECIMAL : '-'? INT_FRAG '.' [0-9]+ EXP? // 1.35, 1.35E-9, 0.3, -4.5
    |     '-'? INT_FRAG EXP // 1e10 -3e4
    ;

fragment EXP : [Ee] [+\-]? INT ; // \- since - means "range" inside [...]
fragment INT_FRAG : '0' | [1-9] [0-9]* ; // no leading zeros

// Strings
STRING : '"' ~["\r\n]* '"';

// Comments
COMMENT : '//' .*? '\r'? '\n' -> skip;
MULTILINE_COMMENT : '/*' .*? '*/' -> skip;

// Whitespace
WS : [ \n\t\r]+ -> skip;
