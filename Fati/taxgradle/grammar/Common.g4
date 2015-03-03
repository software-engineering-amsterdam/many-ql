grammar Common;

variable : ID;

DECIMAL: '.'DIGIT+ | DIGIT+'.'DIGIT+;
INT : DIGIT+;
DIGIT : [0-9];

LOWERCASE : [a-z]; 
UPPERCASE :  [A-Z]; 

BOOLEANLITERAL
    :   'true'
    |   'false'
    ;
    
ID : (LOWERCASE | UPPERCASE) (LOWERCASE | UPPERCASE | DIGIT )*;

LPAR            : '(';
RPAR            : ')';
ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
TILDE           : '~';
QUESTION        : '?';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';
BITAND          : '&';
BITOR           : '|';
CARET           : '^';
MOD             : '%';
SINGLEQUOTE     : '\'';

DOULEQUOTE : '"';
NEWLINE  : [\r\n]+ ;
COLON : ':';
LBRA: '{';
RBRA: '}';
SLASH: '/';

WS  :  [ \t\r\n]+ -> skip;