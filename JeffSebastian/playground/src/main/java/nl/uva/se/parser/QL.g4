grammar QL;

options {
	language = Java;
}

@lexer::header {
package nl.uva.se.parser;
}

@parser::header {
package nl.uva.se.parser;
}

form : 		FORM IDENTIFIER STARTSYMBOL (question|ifClause)* ENDSYMBOL;
question : 	IDENTIFIER TYPE ':' STRING;
ifClause : 	IFCLAUSE '(' IDENTIFIER ')' STARTSYMBOL question* ENDSYMBOL;

// Tokens

FORM : 			'FORM' | 'Form' | 'form';
IFCLAUSE : 		'IF' | 'If' | 'if';
TYPE : 			'boolean' | 'money';
OPERATOR : 		'+' | '-' | '*' | '/';

STRING : 		'"' .*? '"';
WHITESPACE : 	[ \t\r\n]+ -> skip ;
STARTSYMBOL : 	'{';
ENDSYMBOL : 	'}';
IDENTIFIER:   	[a-zA-Z][a-zA-Z0-9]*;
MARKER :		'?' | '!';
DECIMAL :		INTEGER '.' INTEGER ;
INTEGER :	 	('0'..'9')+;