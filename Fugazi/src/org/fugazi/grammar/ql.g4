grammar QL;

/**
 * =====================
 * GENERAL DEFINITIONS
 * =====================
 */


// TODO equal operators at the same level
// expression ('*' | '/') expression
// change float -> something which deals with money better


// complete form - topmost node
form    : 'form' ID '{' stat* '}';

// statement - can be a question or an if statement
stat    : questionDecl
        | if_statement
        ;

// an if statement
// supported form: if(expr){...}
if_statement : 'if' '(' logical_expression ')' '{' questionDecl+ '}';

// question types
// two supported versions:
// 1. Question expecting user's answer.
// 2. Question (field) value of which is derived from other variables / values.
questionDecl    : type ID '(' STRING ')' ';'
                | type ID '(' STRING ')' '=' expression ';'
                ;

// all alowed variable types.
type    : 'bool' | 'float' | 'int' ;

/**
 * =====================
 * NUMERICAL OPERATIONS
 * =====================
 */

// allowed assignable expressions.
expression  : '(' expression ')'
            | expression ('*' | '/') expression
            | expression ('+' | '-') expression
            | ID
            | NUMBER
            ;

/**
 * =====================
 * LOGICAL OPERATIONS
 * =====================
 */

// this defines what a logical expression looks like.
// supported expressions:
// 1. if (value)
// 2. if (value || value && value..)
// 3. if (value && value || value.. ..)
// 4. if (!value)
// 5. if (value && !value..)
logical_expression  : '(' logical_expression ')'
                    | '!' logical_expression
                    | logical_expression '&&' logical_expression
                    | logical_expression '||' logical_expression
                    | logical_expression ('>' | '>=' | '<' | '<=' | '==' | '!=') logical_expression
                    | ID
                    | NUMBER
                    ;

/**
 * =====================
 * LEXER RULES
 * =====================
 */

// identifier definition
// user to identify variable names
ID  :   [a-zA-Z]+;

// Number types, used for numerical statements.
NUMBER : INT | FLOAT;

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

// Fragments
fragment ESC :   '\\' (["\\/bfnrt] | UNICODE) ;
fragment UNICODE : 'u' HEX HEX HEX HEX ;
fragment HEX : [0-9a-fA-F] ;
fragment DIGIT   : [0-9] ; // match single digit