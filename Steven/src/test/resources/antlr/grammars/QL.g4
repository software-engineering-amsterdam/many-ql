grammar QL;
form
    : 'form' identifier '{' statement+ '}';
statement
    : question
    | if_statement
    ;
if_statement
    : 'if' '(' expression ')' '{' statement+ '}' else_clause?
    ;
else_clause
    : 'else' '{' statement+ '}'
    ;
expression
    : leftParenthesis='(' expression rightParenthesis=')'
    | negation='!' expression
    | left=expression (multiplication='*' | division='/')                                       right=expression
    | left=expression (addition='+'| subtraction='-')                                           right=expression
    | left=expression (greatherThan='>' | lessThan='<' | lessOrEqual='<=' | greaterOrEqual='>=')right=expression
    | left=expression (equal='==' | notEqual='!=')                                              right=expression
    | left=expression (and='&&')                                                                right=expression
    | left=expression (or='||')                                                                 right=expression
    | numbers=NUMBERS
    | identifier
    | booleanExpression
    ;
booleanExpression
    : isTrue='true'
    | isFalse='false'
    ;
identifier
    : (UPPERCASE | LOWERCASE | NUMBERS)+
    ;
question
    : identifier question_type question_label question_expression?
    ; // if question has an expression it is a computed question.
question_expression
    : '(' expression ')'
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

COMMENT_LINE
    : '//' ~[\r\n]* -> skip
    ;
WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines