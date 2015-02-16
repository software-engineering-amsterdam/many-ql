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

block
	: '{' blockBody'}'
	;

blockBody
	: declarations
	| statement
	;
	
declarations
	: IDENTIFIER TYPE ':' 
	|
	;

statement
	: block
	| IF '(' condition ')' statement (ELSE statement)? 
	;

condition
	: expr op('==')
	;
	
//Fragments
fragment DIGIT				: ('0'..'9');
fragment LETTER 			: [a-zA-Z];
fragment LETTER_AND_NUMBER  : [a-zA-Z0-9]; 

// Tokens
FORM 		: 'form'|'Form'|'FORM';
IDENTIFIER	:	LETTER_AND_NUMBER*;

//Statements TOKENS
IF 	 : 'if'|'If'|'IF';
ELSE : 'else'|'Else'|'ELSE';

//CONDITION TOKENS
OR 					: '||';
AND 				: '&&';
EQUAL 				: '==';
NOT_EQUAL			: '!=';
GREATER_THAN		: '>' ;
LESS_THEN			: '<' ;
GREATER_OR_EQUAL	: '>=';
LESS_OR_EQUAL		: '<=';
NOT					: '!' ;

//MATH TOKENS
POW					: '^' ;
MOD					: '%' ;
DIV					: '/' ;
MULT				: '*' ;
MINUS				: '-' ;
PLUS				: '+' ;