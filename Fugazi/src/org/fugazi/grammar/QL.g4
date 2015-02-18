grammar QL;

/**
 * =====================
 * GENERAL DEFINITIONS
 * =====================
 */

// complete form - topmost node
form    : 'form' ID '{' statement* '}';

// statement - can be a question or an if statement
statement   : questionDeclaration
            | ifStatement
            ;

// an if statement
// supported form: if(expr){...}
ifStatement : 'if' '(' expression ')' '{' (statement)* '}';

// Question types
// two supported versions:
// 1. Question expecting user's answer.
// 2. Question (field) value of which is computed from other variables / values.
questionDeclaration : type ID '(' STRING ')' ';'                             # noAssignmentQuestion
                    | type ID '(' STRING ')' '=' expression ';'              # assignmentQuestion
                    ;

// all alowed variable types.
type    : 'bool'        # boolType
        | 'int'         # intType
        | 'string'      # stringType
        ;
/**
 * =====================
 * Expressions
 * =====================
 */

// this defines what an expression looks like. (logical and numerical)
expression  : op=('+'|'-'|'!') expression                                           # unaryExpression
            | expression op=('*' | '/') expression                                  # mulDivExpression
            | expression op=('+' | '-') expression                                  # addSubExpression
            | expression op=('>' | '>=' | '<' | '<=' | '==' | '!=') expression      # comparisonExpression
            | expression '&&' expression                                            # logicalAndExpression
            | expression '||' expression                                            # logicalOrExpression
            | BOOLEAN                                                               # booleanExpression
            | ID                                                                    # identifierExpression
            | INT                                                                   # intExpression
            | STRING                                                                # stringExpression
            | '(' expression ')'                                                    # parenthesisExpression
            ;

/**
 * =====================
 * LEXER RULES - literals
 * =====================
 */

// identifier definition
// user to identify variable names
ID  :   [a-zA-Z]+;

// string definition
STRING :  '"' (ESC | ~["\\])* '"' ;

// boolean value definition
BOOLEAN: ["true"|"false"];

// integer definition
// integer is a sequence of digits of a length that can vary
INT : DIGIT+ ;

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