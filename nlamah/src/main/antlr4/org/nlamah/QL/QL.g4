grammar QL;

form : 'form' ID '{' (formElement)* '}' ;
formElement : question | conditionalBlock ; 
question : ID TYPE STRING ;

// if ( s ) { t } endif
// if ( s ) { t } else { e } endif
// if ( s ) { t } elsif ( s ) { t } endif
// if ( s ) { t } elsif ( s ) { t } else { e } endif
// ifthen + elif* + else* + endif

conditionalBlock : ifthen elsifthen* elsethen? 'endif';
ifthen : 'if' '(' logicalExpression ')' '{' (formElement)* '}' ;
elsifthen : 'elsif' '(' logicalExpression ')' '{' (formElement)* '}' ;
elsethen : 'else' '{' (formElement)* '}' ;

logicalExpression  :  ID ;

TYPE : 'boolean' | 'money' ;
STRING : '"' .*? '"' ;
ID : [a-zA-Z]+[a-zA-Z0-9]* ;

WS : [ \t\r\n]+ -> skip ;
