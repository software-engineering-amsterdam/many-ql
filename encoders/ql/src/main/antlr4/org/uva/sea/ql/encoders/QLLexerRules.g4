lexer grammar QLLexerRules;

/**
 * TODO:
 * Complement Data Types Date, Decimal and Currency
 */

/** start lexical rules */

FORM             : 'form' ;                     // top-level form

/** basic arithmetic */

MUL              : '*' ;                        // multiply
DIV              : '/' ;                        // divide
ADD              : '+' ;                        // add
SUB              : '-' ;                        // subtract

/** grouping characters */

OBRACE           : '{' ;                        // open curly brace
CBRACE           : '}' ;                        // close curly brace
OPAREN           : '(' ;                        // open parenthesis
CPAREN           : ')' ;                        // close parenthesis

/** boolean logic */

AND              : '&&' ;                       // logical and
OR               : '||' ;                       // logical or
NOT              : '!' ;                        // not

/** comparison */

LESS_THAN        : '<' ;                        // lesser than
MORE_THAN        : '>' ;                        // more than
LESS_OR_EQUAL    : '<=' ;                       // Lesser than or equal to
MORE_OR_EQUAL    : '>=' ;                       // more than or equal to
NOT_EQUAL        : '!=' ;                       // not equal to
EQUAL            : '==' ;                       // equal to

/** 
 * data types
 * TODO: define types, add enumeration for evaluation values 
 */

fragment 
ESCAPE           : '\\"' ;                      // escape double quote

BOOL             : 'true'                       // booleans
                 |'false' 
                 ;
STRING           : '"' (ESCAPE | ~["\\])* '"' ; // strings
INT              : [0-9]+ ;                     // integers
//DATE           :
//DECIMAL        :
//CURRENCY       :

QuestionDataType : 'boolean'                    // possible data types for a question
                 | 'string'
                 | 'integer'
                 | 'date'
                 | 'decimal'
                 | 'currency'
                 ;

/** identifiers */

FormID           : [a-zA-Z]+ ;                  // form identifier
QuestionID       : [a-zA-Z]+ ;                  // question identifier

/** descriptions */

QuestionDesc     : [a-zA-Z]+ ;                  // question description

/** separation rules */

NEWLINE          : '\r'? '\n' ;                 // newlines to parser
WS               : [ \t]+ -> skip ;             // ignore whitespace
