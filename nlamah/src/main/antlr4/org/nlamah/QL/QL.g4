grammar QL;

form : 'form' ID '{' (question | conditional_block)* '}' ;
question : ID TYPE STRING ;

// if ( s ) { t } endif
// if ( s ) { t } else { e } endif
// if ( s ) { t } elsif ( s ) { t } endif
// if ( s ) { t } elsif ( s ) { t } else { e } endif
// ifthen + elif* + else* + endif

conditional_block : ifthen elsifthen* elsethen? 'endif';
ifthen : 'if' '(' logical_expression ')' '{' (question | conditional_block)* '}' ;
elsifthen : 'elsif' '(' logical_expression ')' '{' (question | conditional_block)* '}' ;
elsethen : 'else' '{' (question | conditional_block)* '}' ;

logical_expression  : '(' ID ')';

TYPE : 'boolean' | 'money' ;
STRING : '"' .*? '"' ;
ID : [a-zA-Z]+[a-zA-Z0-9]* ;

WS : [ \t\r\n]+ -> skip ;
