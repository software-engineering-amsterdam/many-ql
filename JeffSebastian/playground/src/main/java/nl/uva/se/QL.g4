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

form : FORM Ident START expression* END;
expression : Ident Ident ':' TYPE;

// Tokens

FORM : 'FORM' | 'Form' | 'form';
BOOLEAN : 'boolean';
TRUE : 'TRUE' | 'True' | 'true';
FALSE : 'FALSE' | 'False' | 'false';
MONEY : 'MONEY' | 'Money' | 'money';
TYPE : BOOLEAN | MONEY;
OPERATOR: '+' | '-' | '*' | '/';

WS    : [ \t\r\n]+ -> skip ;
START : '{';
END : '}';

Ident:   ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
Decimal : Int '.' Int ;
Int: ('0'..'9')+;