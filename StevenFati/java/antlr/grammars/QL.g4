grammar QL;
start
    : 'form' identifier '{' statement+ '}';

statement
    : question
    | if_statement
    ;

if_statement
    : 'if' '(' expression ')' '{' statement '}' else_clause?
    ;
else_clause
    : 'else' '{' statement '}'
    ;
expression
    : '(' expression ')'
    | negation='!' expression
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
    | ('>' | '<' | '<=' | '>=')
    | ('==' | '!=')
    | '&&'
    | '||'
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
question
    : identifier question_type question_label
    ;
question_type
    : 'STRING'
    | 'INTEGER'
    | 'BOOLEAN'
    | 'DATE'
    | 'MONEY'
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

COMMENT_LINE
    : '//' ~[\r\n]* -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines