grammar QL;

r 	: 'hello' ID ; 			// match keyword hello followed by an identifier
ID 	: [a-z]+ ; 				// match lower-case identifiers
WS 	: [ \t\r\n]+ -> skip ; 	// skip spaces, tabs, newlines, \r (Windows)

stat: ID '=' expr ';';
expr: INT;
INT: [0..9]+;