grammar QL;

options {
	language = Java;
}

@lexer::header {
package nl.uva.se.ql.parser;
}

@parser::header {
package nl.uva.se.ql.parser;
}
	
// -------- PARSER RULES --------

form
	: FORM Identifier '{' (statement)+ '}'
	;

question
	: Type Identifier ':' String ('(' expression ')')?
	;

condition
	: IF expression '{' (statement)+ '}' (ELSE '{' (statement)+ '}')?
	;

statement	
	: question | condition
	;

expression                          				  								
 : '(' expr=expression ')'
 | singleLtr=literal
 | op=(NOT | PLUS | MINUS) singleExpr=expression
 | left=expression op=(MULTIPLY | DIVIDE | MODULO | POWER) right=expression
 | left=expression op=(PLUS | MINUS) right=expression
 | left=expression op=(LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THEN | GREATER_THAN) right=expression
 | left=expression op=(EQUAL | NOT_EQUAL) right=expression
 | left=expression op=AND right=expression
 | left=expression op=OR right=expression
 ;

literal
	: Integer
	| Decimal
	| Boolean
	| String
	| Identifier
	;

// -------- LEXER RULES --------

Type
	: 'boolean'
	| 'decimal'
	| 'integer'
	| 'string'
	;
	
// FRAGMENTS
fragment DIGIT				: [0-9];
fragment LETTER_AND_NUMBER  : [a-zA-Z_][a-zA-Z_0-9]*;

// KEYWORD TOKENS
FORM 	: 'form'|'Form'|'FORM';
IF 	 	: 'if'|'If'|'IF';
ELSE 	: 'else'|'Else'|'ELSE';

// CONDITION TOKENS
OR 					: '||';
AND 				: '&&';
EQUAL 				: '==';
NOT_EQUAL			: '!=';
GREATER_THAN		: '>' ;
LESS_THEN			: '<' ;
GREATER_OR_EQUAL	: '>=';
LESS_OR_EQUAL		: '<=';
NOT					: '!' ;

// MATH TOKENS
POWER				: '^' ;
MODULO				: '%' ;
DIVIDE				: '/' ;
MULTIPLY			: '*' ;
MINUS				: '-' ;
PLUS				: '+' ;

// LITERALS
Integer				: DIGIT*;
Decimal				: DIGIT* '.' DIGIT*;
Boolean				: 'true' | 'false';
String				: '"' .*? '"';
Identifier			: LETTER_AND_NUMBER*;

// OVERHEAD
WS:(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);
MC: '/*' .*? '*/' -> channel(HIDDEN);
SC: '//' .*? '\n' -> channel(HIDDEN);