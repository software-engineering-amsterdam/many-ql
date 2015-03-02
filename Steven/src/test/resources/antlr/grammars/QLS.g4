grammar QLS;
stylesheet
    : 'stylesheet' identifier '{' (page | statement)+ '}'
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
statement
    : question
    | default_statement
    ;
default_statement
    : 'default' question_type '{' style* '}'
    ;
question_type
    : UPPERCASE
    ;
page
    : 'page' '{' section* '}'
    ;
section
    : 'section' STRING '{' statement+ '}'
    ;
question
    : 'question' identifier '{' style* '}'
    | 'question' identifier
    ;
style
    : 'widget' UPPERCASE
    | 'width' NUMBERS
    | 'font' STRING
    | 'color' '#' NUMBERS
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
COMMENT_LINE
    : '//' ~[\r\n]* -> skip
    ;
WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines