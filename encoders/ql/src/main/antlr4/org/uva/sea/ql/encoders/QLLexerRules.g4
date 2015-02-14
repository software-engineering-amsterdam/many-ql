lexer grammar QLLexerRules;

/** start lexical rules */

FORM :    'form' ;            // top-level form
OBRACE :  '{' ;               // open brace
CBRACE :  '}' ;               // close brace
ID :      [a-zA-Z]+ ;         // identifiers
INT :     [0-9]+ ;            // integers
BOOL :    'boolean' ;         // boolean
NEWLINE : '\r'? '\n' ;        // newlines to parser
WS :      [ \t]+ -> skip ;    // ignore whitespace
