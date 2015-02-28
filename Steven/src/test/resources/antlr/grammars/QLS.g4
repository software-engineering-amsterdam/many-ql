grammar QLS;
stylesheet
    : 'stylesheet' identifier '{' (page | statement)+ '}'
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
statement
    : question
    | default
    ;
default
    : 'default' UPPERCASE
    ;
page
    : 'page' '{' section* '}'
    ;
section
    : 'section' '{' statement+ '}'
    ;
question
    : 'question' identifier '{' style* '}'
    | 'question' identifier
    ;
style
    : 'widget' UPPERCASE
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