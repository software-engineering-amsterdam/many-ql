// Define a grammar called Hello
grammar Hello;
r  : 'hello' ID ;         // match keyword hello followed by an identifier
ID : [a-z]+ 'doei' S*           ;// match lower-case identifiers
S :[0-9];
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

