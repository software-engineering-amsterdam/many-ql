lexer grammar EncodersQLSLexerRules;


HEXCOLOR: HEX HEX HEX HEX HEX HEX;

HEX: [0-9A-F];


DATATYPE      : ( BOOLEAN 
                | INTEGER 
                | STRING
                );
                
BOOLEAN       : 'boolean';
INTEGER       : 'integer';
STRING        : 'string';

STRINGLITERAL  : '"' (ESCAPE | .)*? '"';
BOOLEANLITERAL: 'true' | 'false';
INTEGERLITERAL: [0-9]+;

NAME          : [a-zA-Z]+;

ESCAPE        : '\\"';

COMMENT       : ('//' .*? NL) -> skip;

WS            : (' ' | '\t')+ -> skip;
NL            :  ('\r'? '\n') -> skip;
