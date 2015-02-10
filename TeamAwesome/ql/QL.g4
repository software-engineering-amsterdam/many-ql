grammar QL;

import QL_tokens;

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