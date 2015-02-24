/**
 * QL GRAMMAR
 */
grammar QL;

@header{
	package uva.ql.parser;
	import uva.ql.ast.expressions.*;
	import uva.ql.ast.expressions.literals.*;
	import uva.ql.ast.expressions.math.*;
	import uva.ql.ast.expressions.logic.*;
	import java.util.*;
}

prog	: form EOF ;

form	: 'form' Identifier '{' stms+=stat* '}' ;

quest 	: 'question' Identifier 'typeof' primitiveType '{' stms+=stat*'}';

stat	: expr
		| quest
	 	| ifStatement								
	 	| assign
	 	;

assign		: Identifier '=' exp = expr ';' 	# AssignExpr			
			| Identifier '=' str = STRING ';' 	# AssignStr; 				

expr 		: LP x = expr RP
			| x = expr op = EXP<assoc=right> y = expr 	
			| x = expr op = (MUL | DIV) y = expr
			| x = expr op = (ADD | SUB) y = expr
			| x = expr op = (LESS |LESS_EQUAL | GREATER | GREATER_EQUAL) y = expr
			| x = expr op = (EQUAL | NOT_EQUAL) y = expr
			| x = expr op = LOG_AND y = expr
			| x = expr op = LOG_OR y = expr																		
			| lit = literal																		
			;
	
ifStatement		: 'if' '(' expr ')' '{' stms+=stat* '}';
	

literal		: BooleanLiteral
			| Integer		
			| Decimal
			| Identifier							
			;

QuestionLiteral	: 'OrdinaryQuestion'
				| 'ComputableQuestion'
				;

BooleanLiteral 	: 'true'
				| 'false'
				;

primitiveType	: 'boolean'
				| 'decimal'
				| 'string'
				| 'int'
				;

Identifier	: ID_LETTER (ID_LETTER | DIGIT)* ;

Integer		: (DIGIT | ('(-'DIGIT')')) ;

Decimal		: ('(''-')? DIGIT+ '.' DIGIT* ')'? ;

WS			: (' ' | NL | '\t') -> skip;

/* It gets form, if etc as an identifier and not as keywords */

ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

DIGIT			: '0' | [1-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

/* KEYWORDS - TOKENS */ 


MUL			: '*' ;
DIV			: '/' ;
ADD			: '+' ;
SUB			: '-' ;
LP			: '(' ;
RP			: ')' ;
LC			: '{' ;
RC			: '}' ;
LESS		: '<' ;
LESS_EQUAL 	: '<=';
GREATER		: '>' ;
GREATER_EQUAL 	: '>=';
EQUAL  		: '==';
LOG_AND		: '&&';
LOG_OR		: '||';
NOT_EQUAL	: '!=';
NL			: '\r'? '\n';
EXP			: '^' ;

/* semantic actions - next to the production rules, and then call the constructor */
/* create a class that implements the visitor - because ANTLR generates only visitor interface */
/* the listener ->  */
