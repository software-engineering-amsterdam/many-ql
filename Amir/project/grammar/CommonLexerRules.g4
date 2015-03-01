lexer grammar CommonLexerRules; // note "lexer grammar"

//Types
BOOL_TYPE : 'boolean' ;
STRING_TYPE : 'string' ;
INT_TYPE : 'integer' ;
DATE_TYPE    : 'date' ;
DECIMAL_TYPE : 'decimal' ;
MONEY_TYPE   : 'money' ;

// computation tokens
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';

// condition tokens
NOT: '!';
LT:  '<';
GT:  '>';
LEQ: '<=';
GEQ: '>=';
EQ:  '==';
NEQ: '!=';
AND: '&&';
OR:  '||';

////Conditionals
//IF   :   'if' ;
//ELSE :   'else';


//Booleans
TRUE  :  'true'; // #True
FALSE : 'false'; // #False

// Identifiers
ID  :   [a-zA-Z][a-zA-Z0-9]*;

//Numbers
INT :   [0-9]+ ;

STRING :  '"' (ESC | ~["\\])* '"' ;

fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;

COMMENT: '//' .*? '\r'? '\n' -> skip;
MULTYLINE_COMMENT:  '/*' .*? '*/' -> skip;

WS  :  [ \n\t\r]+ -> skip ;


