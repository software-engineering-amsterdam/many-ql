grammar QL;

import QL_tokens, QL_expr;

statement 
    :   form
    |   question
    |   if_statement
    ;

form
    :   'form' ID '{' statement* '}'
    ;

question
    :   'question' ID '{' STRING question_type '}'
    ;

if_statement
    :   'if' expr '{' statement* '}'
    ;

WS  
    :   [ \n\r\t]+ -> skip
    ;

COMMENT  
    :    '//' ~[\r\n]* -> skip
    ;