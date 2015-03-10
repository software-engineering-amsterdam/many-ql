lexer grammar EncodersQLLexerRules;

DATATYPE      : ( BOOLEAN 
                | INTEGER 
                | STRING
                );

BOOLEAN       : 'boolean';
INTEGER       : 'integer';
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


NAME          : [a-zA-Z]+;

STRINGLITERAL  : '"' .+? '"';
BOOLEANLITERAL: 'true' | 'false';
INTEGERLITERAL: [0-9]+;

WS            : (' ' | '\t')+ -> skip;
NL            :  ('\r'? '\n') ->skip;
