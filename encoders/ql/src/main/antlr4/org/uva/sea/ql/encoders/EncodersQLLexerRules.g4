lexer grammar EncodersQLLexerRules;

DATATYPE      : ( BOOLEAN 
                | INTEGER 
                | STRING
                );

BOOLEAN       : 'boolean';
INTEGER       : 'int';
STRING        : 'string';

MULDIV: MUL | DIV;
ADDSUB: ADD | SUB;
LTGTLEGE: LT | GT | LE | GE;
NEEQ: NE | EQ;

MUL           : '*';
DIV           : '/';
ADD           : '+';
SUB           : '-';

AND           : '&&';
OR            : '||';
NOT           : '!';

LT            : '<';
GT            : '>';
LE            : '<=';
GE            : '>=';

NE            : '!=';
EQ            : '==';

QUOTEDSTRING  : '"' .+? '"';

NAME          : [a-zA-Z]+;

WS            : (' ' | '\t')+ -> skip;
NL            :  ('\r'? '\n') ->skip;
