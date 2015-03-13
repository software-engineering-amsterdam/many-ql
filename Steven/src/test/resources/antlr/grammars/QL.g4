grammar QL;
form
    : 'form' identifier '{' statement+ '}';
statement
    : question      #questionLabel
    | if_statement  #if_statementLabel
    ;
if_statement
    : 'if' '(' expression ')' '{' statement+ '}' else_clause?
    ;
else_clause
    : 'else' '{' statement+ '}'
    ;
expression
    : leftParenthesis=  '('     expression rightParenthesis     =')' #parenthesis
    |                   '!'     expression #negationLabel
    | left=expression   '*'     right=expression #multiplication
    | left=expression   '/'     right=expression #division
    | left=expression   '+'     right=expression #addition
    | left=expression   '-'     right=expression #subtraction
    | left=expression   '>'     right=expression #greaterThan
    | left=expression   '<'     right=expression #lessThan
    | left=expression   '<='    right=expression #lessOrEqual
    | left=expression   '>='    right=expression #greaterOrEqual
    | left=expression   '=='    right=expression #equal
    | left=expression   '!='    right=expression #notEqual
    | left=expression   '&&'    right=expression #and
    | left=expression   '||'    right=expression #or
    | numbers=      NUMBERS     #numbersLabel
    | identifier                #identifierLabel
    | booleanExpression         #booleanExpressionLabel
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