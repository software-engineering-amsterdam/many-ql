grammar QL;
start
    : 'form' identifier '{' statement+ '}';

statement
    : question
    | if_statement
    ;

if_statement
    : 'if' '(' expression ')' '{' statement '}'
    ;
expression
    : '(' expression ')'
    | expression operator expression
    | NUMBERS+
    | identifier+
    | bool+
    ;

bool
    : 'true'
    | 'false'
    ;
operator
    : ('*' | '/')
    | ('+'| '-')
    | '&&'
    | '||'
    | ('>' | '<')
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
question
    : identifier question_type question_label
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