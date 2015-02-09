grammar QL;
form
    :   'form' numeric '{' numeric numeric '"' numeric '"' '}';

numeric
    : Number
    | LowerCaseString
    | UpperCaseString
    ;

NUMBER
    : [0-9]+
    ;
LowerCaseString
    : [a-z]+
    ;
UpperCaseString
    : [A-Z]+
    ;
WS
    : [ \t\r\n]+ -> skip
    ; // skip spaces, tabs, newlines