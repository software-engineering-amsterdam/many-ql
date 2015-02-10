grammar QL;

import QL_tokens, QL_expr;

statement 
    :   form
    |   question
    |   if_statement
    ;

form
    :   'form' identifier '{' statement* '}'
    ;

question
    :   'question' identifier '{' string question_type '}'
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