grammar QL2;

form:
    'form' WS formName=NAME WS '{' WS* NL
    (question | conditionalBlock | NL )+
    '}'
    EOF;

        
question:
    WS* questionString=QUOTEDSTRING NL
    WS* questionName=NAME ':' WS type=TYPE NL;


    
conditionalBlock:
    WS* 'if' WS '(' conditional ')' WS '{' NL
    question+
    WS* '}' NL;
    
conditional:
    NAME;
    
TYPE: (BOOLEAN | INTEGER | STRING | MONEY);

BOOLEAN: 'boolean';
INTEGER: 'int';
STRING: 'string';
MONEY: 'money';


QUOTEDSTRING: '"' .+? '"' ;

NAME: [a-zA-Z]+;

WS: (' ' | '\t')+;
NL:  '\r'? '\n';
