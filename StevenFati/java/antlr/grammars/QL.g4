grammar QL;
start
    : 'form' form_name '{' question+ '}';

form_name
    : (UPPERCASE | LOWERCASE | NUMBERS)*
    ;
question
    : question_name question_type question_label
    ;
question_name
    : (UPPERCASE | LOWERCASE | NUMBERS)*
    ;
question_type
    : UPPERCASE
    ;
question_label
    : STRING
    ;


UPPERCASE
    : [A-Z]+
    ;
LOWERCASE
    : [a-z]+
    ;
NUMBERS
    : [0-9]+
    ;

STRING
    : '"' (~[\r\n"] | '""')* '"'
    ;
WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines