lexer grammar EncodersQLLexerRules;

STRINGLITERAL : '"' (ESCAPE | .)*? '"';
BOOLEANLITERAL: 'true' | 'false';
INTEGERLITERAL: [0-9]+;

NAME          : [a-zA-Z]+[a-zA-Z0-9]*;

ESCAPE        : '\\"';

COMMENT       : ('//' .*? NL) -> skip;

WS            : (' ' | '\t')+ -> skip;
NL            :  ('\r'? '\n') -> skip;
