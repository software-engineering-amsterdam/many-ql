grammar QL;

statement 
    :   form_statement
    |   question_statement
    |   if_statement
    ;

form_statement
    :   'form' identifier '{' statement* '}'
    ;

question_statement
    :   'question' identifier '{' string question_type ('=' expr)? '}'
    ;

if_statement
    :   'if' expr '{' statement* '}'
    ;

question_type
    :   'boolean' 
    |   'integer' 
    |   'string'
    |   'money'
    ;

expr
    :   '(' expr ')'
    |   op=('+' | '-' | '!') right=expr
    |   left=expr op='^' right=expr
    |   left=expr op=('*' | '/' | '%') right=expr
    |   left=expr op=('+' | '-') right=expr
    |   left=expr op=('<' | '<=' | '>' | '>=') right=expr
    |   left=expr op=('==' | '!=') right=expr
    |   left=expr op='&&' right=expr
    |   left=expr op='||' right=expr
    |   left=atom
    ;

atom
    :   boolean
    |   string
    |   integer
    |   identifier
    |   money
    ;

boolean
    :   'true'
    |   'false'
    ;

identifier : IDENTIFIER ;
string     : STRING ;
integer    : INTEGER ;
money      : MONEY ;

STRING       : '"' (ESC | ~["\\])* '"' ;
fragment ESC : '\\' (["\\/bfnrt]) ;

INTEGER    : '-'? '0' | [1-9] [0-9]*  ;
MONEY      : INTEGER ('.' [0-9]+)? ;
IDENTIFIER : [a-zA-Z_][a-zA-Z_0-9]* ;

WS      : [ \n\r\t]+    -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;