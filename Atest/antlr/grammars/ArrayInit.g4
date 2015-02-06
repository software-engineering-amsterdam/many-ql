grammar ArrayInit;

init : '{' value (',' value)* '}' ; // must match at least one value
value : init
| INT
;
// parser rules start with lowercase letters, lexer rules with uppercase
INT : [0-9]+ ; // Define token INT as one or more digits
WS : [ \t\r\n]+ -> skip ; 