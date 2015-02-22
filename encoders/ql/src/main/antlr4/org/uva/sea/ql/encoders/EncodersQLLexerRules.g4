lexer grammar EncodersQLLexerRules;

DATATYPE      : ( BOOLEAN 
                | INTEGER 
                | STRING 
                | MONEY
                ) ;

BOOLEAN       : 'boolean' ;
INTEGER       : 'int' ;
DECIMAL       : 'decimal' ;
STRING        : 'string' ;
MONEY         : 'money' ;
DATE          : 'date' ;

MULDIV: MUL | DIV;
ADDSUB: ADD | SUB;

MUL           : '*' ;
DIV           : '/' ;
ADD           : '+' ;
SUB           : '-' ;

AND           : '&&' ;
OR            : '||' ;
NOT           : '!' ;

LT            : '<' ;
GT            : '>' ;
LE            : '<=' ;
GE            : '>=' ;
NE            : '!=' ;
EQ            : '==' ;

QUOTEDSTRING  : '"' .+? '"' ;

NAME          : [a-zA-Z]+ ;

WS            : (' ' | '\t')+ -> skip ;
NL            :  '\r'? '\n' ;
