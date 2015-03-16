lexer grammar EncodersQLLexerRules;

DATATYPE      : ( 'boolean' | 'integer' | 'string' );

STRINGLITERAL : '"' (ESCAPE | .)*? '"';
BOOLEANLITERAL: 'true' | 'false';
INTEGERLITERAL: [0-9]+;

NAME          : [a-zA-Z]+[a-zA-Z0-9]*;

ESCAPE        : '\\"';

COMMENT       : ('//' .*? NL) -> skip;

WS            : (' ' | '\t')+ -> skip;
NL            :  ('\r'? '\n') -> skip;
