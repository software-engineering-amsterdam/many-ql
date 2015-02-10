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

form : FORM IDENTIFIER STARTSYMBOL question* ENDSYMBOL;
question : IDENTIFIER TYPE ':' '"' IDENTIFIER* '"';

// Tokens

FORM : 'FORM' | 'Form' | 'form';
TYPE : 'boolean' | 'money';
OPERATOR: '+' | '-' | '*' | '/';

WHITESPACE : 	[ \t\r\n]+ -> skip ;
STARTSYMBOL : 	'{';
ENDSYMBOL : 	'}';
IDENTIFIER:   	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'?')*;
MARKER :		'?' | '!';
/*  DECIMAL :		INTEGER '.' INTEGER ;
INTEGER:	 	('0'..'9')+; */