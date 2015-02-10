grammar QL;

/**
 * =====================
 * GENERAL DEFINITIONS
 * =====================
 */

// TODO change float -> something which deals with money better


// complete form - topmost node
form    : 'form' ID '{' statement* '}';

// statement - can be a question or an if statement
statement   : questionDeclaration           # stamentQuestoinDeclaration
            | ifStatement                   # stamentifStatement
            ;

// an if statement
// supported form: if(expr){...}
ifStatement : 'if' '(' logicalExpression ')' '{' (ifStatement | questionDeclaration)* '}';

// question types
// two supported versions:
// 1. Question expecting user's answer.
// 2. Question (field) value of which is derived from other variables / values.
questionDeclaration : type ID '(' STRING ')' ';'                             # noAssignmentQuestion
                    | type ID '(' STRING ')' '=' numericalExpression ';'     # assignmentQuestion
                    ;

// all alowed variable types.
type    : 'bool' | 'float' | 'int' ;

/**
 * =====================
 * NUMERICAL OPERATIONS
 * =====================
 */

// allowed assignable expressions.
numericalExpression  : '(' numericalExpression ')'                    # bracketedExpression
            | numericalExpression ('*' | '/') numericalExpression     # mulDivExpression
            | numericalExpression ('+' | '-') numericalExpression     # addSubExpression
            | ID                                                      # expressionId
            | NUMBER                                                  # expressionNumber
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
logicalExpression  : '(' logicalExpression ')'                                                      # nestedExpression
                   | '!' logicalExpression                                                          # negation
                   | logicalExpression ('>' | '>=' | '<' | '<=' | '==' | '!=') logicalExpression    # comparison
                   | logicalExpression '&&' logicalExpression                                       # logicalAnd
                   | logicalExpression '||' logicalExpression                                       # logicalOr
                   | ID                                                                             # logicalId
                   | NUMBER                                                                         # logicalNumber
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