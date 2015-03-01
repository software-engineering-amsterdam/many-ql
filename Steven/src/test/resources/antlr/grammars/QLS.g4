grammar QLS;
stylesheet
    : 'stylesheet' identifier '{' stylesheet_element+ '}'
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
stylesheet_element
    : page
    | statement
    ;
page
    : 'page' '{' section* '}'
    ;
section
    : 'section' STRING '{' statement+ '}'
    ;
statement
    : question
    | default_statement
    ;
question
    : 'question' identifier '{' style* '}'
    | 'question' identifier
    ;
default_statement
    : 'default' question_type '{' style* '}'
    ;
question_type
    : UPPERCASE
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