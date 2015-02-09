// Define a grammar called Hello
grammar Hello;

@lexer::header {
package nl.uva.softwcons.generated;
}
 
@parser::header {
package nl.uva.softwcons.generated;
}

r  : 'hello' ID ;         // match keyword hello followed by an identifier
ID : [a-z]+ ;             // match lower-case identifiers
WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines