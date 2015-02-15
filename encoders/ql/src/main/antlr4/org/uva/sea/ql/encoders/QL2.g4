grammar QL2;

form: 
    'form' WS formName=NAME WS '{' WS* NL
    question=questionRule+
    '}'
    EOF;

questionRule:
    WS* questionString=QUESTIONSTRING NL
    WS* questionName=NAME ':' WS type=TYPE NL;
    
TYPE: (BOOLEAN | INTEGER | STRING);

BOOLEAN: 'boolean';
INTEGER: 'int';
STRING: 'string';

QUESTIONSTRING: '"' [a-zA-Z0-9 ]+ '?"' ;

NAME: [a-zA-Z]+;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';
