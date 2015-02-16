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
// if question has an expression it is a computed question.
question
    : identifier question_type question_label expression?
    ;
question_type
    : 'STRING'
    | 'INTEGER'
    | 'BOOLEAN'
    | 'DATE'
    | 'MONEY'
    | 'DECIMAL'
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