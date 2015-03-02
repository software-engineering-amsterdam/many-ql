lexer grammar Ident;

fragment Letter : [a-zA-Z];

fragment Digit : [0-9];

Identifier : (Letter)(Letter|Digit|'_')*;