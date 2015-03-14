lexer grammar SharedTokens;


INT    : '-'? DIGIT+ ;             // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       // match anything between "..." (nongreedy)
COLOR  : '#' HEX HEX HEX HEX HEX HEX ;
DATE   : '[' DAY '-' MONTH '-' YEAR ']' 
       | '[today]'
	   | '[yesterday]'
	   | '[tomorrow]'
       ;

TYPE : 'int' | 'string' | 'bool' | 'date';

ID : LETTER (LETTER | DIGIT)* ;

// Helper tokens; (not vissible to the parser)
DAY    : DIGIT DIGIT? ;
MONTH  : DIGIT DIGIT? ;
YEAR   : DIGIT DIGIT DIGIT DIGIT ;

DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
HEX    : [0-9A-F] ;
ESC    : '\\"' | '\\\\' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out




