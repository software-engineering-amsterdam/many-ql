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
    : 'else' '{' statement '}'
    ;
expression
    : leftParenthesis='(' expression rightParenthesis=')'
    | negation='!' expression
    | left=expression arithmeticOperator right=expression
    | left=expression logicalOperator right=expression
    | numbers=NUMBERS
    | identifier
    | booleanExpression
    ;
booleanExpression
    : isTrue='true'
    | isFalse='false'
    ;
arithmeticOperator
    : (multiplication='*' | division='/')
    | (add='+'| min='-')
    ;
logicalOperator
    : (greatherThan='>' | lessThan='<' | lessOrEqual='<=' | greaterOrEqual='>=')
    | (equal='==' | notEqual='!=')
    | and='&&'
    | or='||'
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
    : string='STRING'
    | integer='INTEGER'
    | booleanType='BOOLEAN'
    | date='DATE'
    | money='MONEY'
    | decimal='DECIMAL'
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