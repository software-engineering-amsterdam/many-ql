grammar QL_tokens;

tokens { AND, OR, NOT, PLUS, MIN, MULTIPLY, DIVIDE}

  AND      : '&&';
  OR       : '||';
  NOT      : '!';
  PLUS     : '+';
  MIN      : '-';
  MULTIPLY : '*';
  DIVIDE   : '/';
  LPAREN   : '(';
  RPAREN   : ')';  
  LT       : '<';
  GT       : '>';
  LTE      : '<=';
  GTE      : '>=';
  EQ       : '==';
  NEQ      : '!=';

boolean
    :   'true'
    |   'false'
    ;

question_type
    :   'boolean' 
    |   'integer' 
    |   'string' 
    ;

STRING :  '"' (ESC | ~["\\])* '"' ;
fragment ESC :   '\\' (["\\/bfnrt]) ;

NUMBER : '-'? '0' | [1-9] [0-9]*  ;

ID 
    :   [a-zA-Z_][a-zA-Z_0-9]* 
    ;

atom
    :   boolean
    |   STRING
    |   NUMBER
    |   ID
    ;