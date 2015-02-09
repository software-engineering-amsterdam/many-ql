grammar ql;

/* GENERAL DEFINITIONS */

// complete form - topmost node
form    : 'form' ID '{' stat+ '}';

// statement - can be a question or an if statement
stat    : question
        | if_statement
        | NEWLINE // TODO determine that
        ;

// an if statement
// supported form: if(expr){...}
if_statement : 'if' '(' logical_expression ')' '{' question+ '}';

// question types
// two supported versions:
// 1. Question expecting user's answer.
// 2. Question (field) value of which is derived from other variables / values.
question: TYPE ID '(' STRING ')' ';'
        | TYPE ID '(' STRING ')' '=' expression ';'
        ;

// all alowed variable types.
TYPE    : 'bool'
        | 'float'
        | 'int'
        ;

// allowed assignable expressions.
expression  : '(' expression ')'
            | expression '*' expression
            | expression '/' expression
            | expression '+' expression
            | expression '-' expression
            | value
            ;


/* LOGICAL OPERATIONS AND TYPES */

// this defines what a logical expression looks like.
// supported expressions:
// 1. if (value)
// 2. if (value || value && value..)
// 3. if (value && value || value.. ..)
// 4. if (!value)
// 5. if (value && !value..)
logical_expression  : '(' logical_expression ')'
                    |'!' logical_expression
                    | logical_expression '&&' logical_expression
                    | logical_expression '||' logical_expression
                    | value '>' value
                    | value '>=' value
                    | value '<' value
                    | value '<=' value
                    | value '==' value
                    | value '!=' value
                    | value
                    ;


// all suported value types
// TODO if we put it in caps it breaks - why?
value   : BOOLEAN
        | INT
        | FLOAT
        | ID
        ;

// identifier definition
// user to identify variable names
ID  :   [a-zA-Z]+;

/* LEXER RULES */

// string definition
STRING :  '"' (ESC | ~["\\])* '"' ;

// boolean value definition
BOOLEAN: ["true"|"false"];

// integer definition
// integer consists of an arbitrary number of digits
INT : DIGIT+ ;

// float definition
// float consists of an arbitrary number of digits, a dot,
// and of an arbitrary number of digits
FLOAT : DIGIT+ '.' DIGIT*   // match 1. 39. 3.14159 etc...
      | '.' DIGIT+          // match .1 .14159
      ;

// text layout definitions
// newline return newlines to parser (is end-statement signal)
NEWLINE :'\r'? '\n' ;
// comment matches anything between /* and */
COMMENT
    :   '/*' .*? '*/'    -> channel(HIDDEN)
    ;
// ignore whitespaces
WS  :   [ \r\t\u000C\n]+ -> channel(HIDDEN)
    ;
// line comment matches anything after // until newline
LINE_COMMENT
    : '//' ~[\r\n]* '\r'? '\n' -> channel(HIDDEN)
    ;
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
fragment DIGIT   : [0-9] ; // match single digit