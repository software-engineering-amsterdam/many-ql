grammar QL;

nested_statement
    :   question_statement
    |   if_statement
    ;

root
    :   form_statement*
    ;

form_statement
    :   'form' name=identifier '{' statements+=nested_statement* '}'
    ;

question_statement
    :   'question' name=identifier '{' text=string qtype=question_type ('=' expression=expr)? '}'
    ;

if_statement
    :   'if' expression=expr '{' statements+=nested_statement* '}'
    ;

question_type
    :   'boolean' 
    |   'integer' 
    |   'string'
    |   'money'
    ;

expr
    :   '(' left=expr ')'
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