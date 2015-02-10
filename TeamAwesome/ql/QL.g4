grammar QL;

import QL_tokens, QL_expr;

form
    :   'form' ID '{' question* '}'
    ;

question
    :   'question' ID '{' STRING boolean '}'
    ;

WS  
    :   [ \n\r\t]+ -> skip
    ;

COMMENT  
    :    '//' ~[\r\n]* -> skip
    ;