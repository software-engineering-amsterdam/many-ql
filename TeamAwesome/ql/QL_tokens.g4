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

STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt]) ;

INTEGER : '-'? '0' | [1-9] [0-9]*  ;

MONEY : INTEGER ('.' [0-9]+)? ;

ID 
    :   [a-zA-Z_][a-zA-Z_0-9]* 
    ;

atom
    :   boolean
    |   STRING
    |   INTEGER
    |   ID
    ;