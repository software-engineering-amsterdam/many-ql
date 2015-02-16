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

parse
	:declaration
	|statement
	;
	
declaration
	: FORM IDENTIFIER						#formDeclaration
	| IDENTIFIER type ':' '"'IDENTIFIER'"'	#typeDeclaration
	;

statement	
	: IF '(' expression ')' statement (ELSE statement)?	#ifStatement
	;

expression                          				  								
 : NOT expression                             				  								#notExpression
 | expression op=(MULTIBLE | DIVIDE | MODULO) expression      								#multiplicationExpression
 | expression op=(PLUS | MINUS) expression          		  								#additiveExpression
 | expression op=(LESS_OR_EQUAL | GREATER_OR_EQUAL | LESS_THEN | GREATER_THAN) expression	#relationalExpression
 | expression op=(EQUAL | NOT_EQUAL) expression              		  						#equalExpression
 | expression AND expression                        		  								#andExpression
 | expression OR expression                         		  								#orExpression
	;

type
	: BOOLEAN
	| DOUBLE
	;
	
//Fragments
fragment DIGIT				: ('0'..'9');
fragment LETTER 			: [a-zA-Z];
fragment LETTER_AND_NUMBER  : [a-zA-Z_] [a-zA-Z_0-9]*; 

// Tokens
FORM 		: 'form'|'Form'|'FORM';
IDENTIFIER	:	LETTER_AND_NUMBER*;
QUESTION	: 'question'|'QUESTION'|'Question';

//types
BOOLEAN	: 'boolean'|'BOOLEAN'|'Boolean';
DOUBLE	: 'double'|'DOUBLE'|'Double'; 

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
POWER					: '^' ;
MODULO					: '%' ;
DIVIDE					: '/' ;
MULTIBLE				: '*' ;
MINUS					: '-' ;
PLUS					: '+' ;