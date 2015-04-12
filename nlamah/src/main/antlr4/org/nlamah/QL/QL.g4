grammar QL;

form : 'form' ID '{' (formElement)* '}' ;
formElement : question | conditionalBlock ; 

question : ID TYPE questionString ;

questionString : STRING ;
// if ( s ) { t } endif
// if ( s ) { t } else { e } endif
// if ( s ) { t } elsif ( s ) { t } endif
// if ( s ) { t } elsif ( s ) { t } else { e } endif
// ifthen + elif* + else* + endif

conditionalBlock : ifThenBlock elseIfThenBlock* elseThenBlock? 'endif';
ifThenBlock : 'if' '(' logicalExpression ')' '{' (formElement)* '}' ;
elseIfThenBlock : 'elseif' '(' logicalExpression ')' '{' (formElement)* '}' ;
elseThenBlock : 'else' '{' (formElement)* '}' ;

logicalExpression  :  ID ;

TYPE : 'boolean' | 'money' ;
STRING : '"' .*? '"' ;
ID : [a-zA-Z]+[a-zA-Z0-9]* ;

WS : [ \t\r\n]+ -> skip ;
