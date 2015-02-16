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
	
form
	: FORM IDENTIFIER '{' (statement)+ '}' #formDeclaration
	;

question
	: type IDENTIFIER ':' String  #questionDeclaration
	;

condition
	: IF '(' expression ')' '{' (statement)+ '}' (ELSE '{' (statement)+ '}')?	#conditionDeclaration
	;

statement	
	: question | condition
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
	
String
    : '"' CHAR+? '"'
    | '\'' CHAR+? '\''
    | '“' CHAR+? '”'
    ;
	
//Fragments
fragment DIGIT				: ('0'..'9');
fragment LETTER 			: [a-zA-Z];
fragment LETTER_AND_NUMBER  : [a-zA-Z_] [a-zA-Z_0-9]*;
fragment CHAR 				: ~[\\]; 

// Tokens
FORM 		: 'form'|'Form'|'FORM';
IDENTIFIER	: LETTER_AND_NUMBER*;
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

WS : [ \t\r\n]+ -> channel(HIDDEN) ;