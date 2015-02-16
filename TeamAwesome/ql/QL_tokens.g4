grammar QL_tokens;

boolean
    :   'true'
    |   'false'
    ;

question_type
    :   'boolean' 
    |   'integer' 
    |   'string'
    |   'money'
    ;

string : STRING ;
STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt]) ;

integer : INTEGER ;
INTEGER : '-'? '0' | [1-9] [0-9]*  ;

money : MONEY ;
MONEY : INTEGER ('.' [0-9]+)? ;

identifier : IDENTIFIER ;
IDENTIFIER 
    :   [a-zA-Z_][a-zA-Z_0-9]* 
    ;

atom
    :   boolean
    |   string
    |   integer
    |   identifier
    |   money
    ;