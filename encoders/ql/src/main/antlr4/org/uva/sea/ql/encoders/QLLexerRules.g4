lexer grammar QLLexerRules;

/** start lexical rules */

FORM :          'form' ;            // top-level form

/** basic arithmetic */

MUL :           '*' ;               // multiply
DIV  :          '/' ;               // divide
ADD  :          '+' ;               // add
SUB  :          '-' ;               // subtract

/** grouping characters */

OBRACE :        '{' ;               // open curly brace
CBRACE :        '}' ;               // close curly brace
OPAREN :        '(' ;               // open parenthesis
CPAREN :        ')' ;               // close parenthesis

/** boolean logic */

AND :           '&&' ;              // logical and
OR :            '||' ;              // logical or
NOT :           '!' ;               // not

/** comparison */

LESS_THAN :     '<' ;               // lesser than
MORE_THAN :     '>' ;               // more than
LESS_OR_EQUAL : '<=' ;              // Lesser than or equal to
MORE_OR_EQUAL : '>=' ;              // more than or equal to
NOT_EQUAL :     '!=' ;              // not equal to
EQUAL :         '==' ;              // equal to

/** 
 ** data types
 ** TODO: define types, add enumeration for evaluation values 
 */

//BOOL :
//STRING :
INT :           [0-9]+ ;            // integers
//DATE :
//DECIMAL :
//CURRENCY :

/** question structures */

QuestionID :    [a-zA-Z]+ ;         // question identifiers

/** separation rules */

NEWLINE :       '\r'? '\n' ;        // newlines to parser
WS :            [ \t]+ -> skip ;    // ignore whitespace
