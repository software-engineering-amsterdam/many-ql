lexer grammar EncodersQLLexerRules;

DATATYPE      : ( BOOLEAN 
                | INTEGER 
                | STRING 
                | MONEY
                );

BOOLEAN       : 'boolean';
INTEGER       : 'int';
DECIMAL       : 'decimal';
STRING        : 'string';
MONEY         : 'money';
DATE          : 'date';

MULDIV: MUL | DIV;
ADDSUB: ADD | SUB;
ANDORNOT: AND | OR | NOT;
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
NL            :  '\r'? '\n';
