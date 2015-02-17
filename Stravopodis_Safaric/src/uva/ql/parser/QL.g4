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

form	: 'form' title=ID '{' sts+=stat* '}' ;

quest 	: 'question' ID typeof primitiveType '{' stat* '}' ;

stat	: quest
	 	| decl
	 	| expr 
	 	| ifStatement
	 	| quest_decl								
	 	| assign
	 	;

quest_decl	: ID '=' STRING ';' 								// quest_decl only within questions
			| ID '.' questionType '=' QuestionLiteral ';'
			| ID '.' 'value' '=' expr ';';	

decl		: primitiveType ID '='? expr? ';';		// Allows int x; && int x = 3 - 1; 

assign		: ID '=' expr ';';

expr returns [Expression result]: x = expr op = EXP<assoc=right> y = expr 
								{
									$result = (new Exponentiation($x.result,$y.result));
								}	
								| x = expr op = (MUL | DIV) y = expr
								{
									if ($op.type == MUL)
									$result = (new Multiplication($x.result,$y.result));
									else
									$result = (new Division($x.result,$y.result));
								}
								| x = expr op = (ADD | SUB) y = expr
								{
									if ($op.type == ADD)
									$result = (new Addition($x.result, $y.result));
									else
									$result = (new Substraction($x.result, $y.result));
								}	
								| x = expr op = (LESS |LESS_EQUAL | GREATER | GREATER_EQUAL) y = expr
								{
									switch($op.type){
										case LESS: 			$result = (new Less($x.result,$y.result,$op.getText()));
										case LESS_EQUAL:	$result = (new Less_Eq($x.result, $y.result, $op.getText()));
										case GREATER:		$result = (new Greater($x.result, $y.result, $op.getText()));
										case GREATER_EQUAL: $result = (new Greater_Eq($x.result, $y.result, $op.getText()));
									}
								}							
								| x = expr op = (EQUAL | NOT_EQUAL) y = expr
								{
									if ($op.type == EQUAL)
									$result = (new Equal($x.result, $y.result, $op.getText()));
									else
									$result = (new NotEqual($x.result, $y.result, $op.getText()));
								}															
								| x = expr op = LOG_AND y = expr
								{
									$result = (new And($x.result, $y.result, $op.getText()));
								}																	
								| x = expr op = LOG_OR y = expr
								{
									$result = (new Or($x.result, $y.result, $op.getText()));
								}																	
								| '(' x = expr ')'																		
								| literal																	
								;
	
ifStatement		: ifThen = 'if' '(' expr ')' '{' stat* '}';
				//| ifElse = 'if' '(' expr ')' '{' stat* '}' elseStat = 'else' '(' stat* ')';
	

literal		: BooleanLiteral
			| (INT | ('(-'INT')'))
			| (FLOAT | ('(-'FLOAT')'))
			| (CURRENCY | ('(-'CURRENCY')'))
			| ID	
			;

QuestionLiteral	: 'OrdinaryQuestion'
				| 'ComputableQuestion'
				;
	
BooleanLiteral 	: 'true'
				| 'false'
				;

primitiveType	: 'boolean'
				| 'float'
				| 'currency'
				| 'string'
				| 'int'
				;

WS			: (' ' | NL | '\t') -> skip;

ID			: ID_LETTER (ID_LETTER | INT)* ;

/* It gets form, if etc as an identifier and not as keywords */

ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

INT			: '0' | [1-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

FLOAT		: INT+ '.' INT*	// How to set the precision to for instance 4? That it returns a value of this precision
			| '.' INT+;

CURRENCY	: FLOAT;

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

/* KEYWORDS - TOKENS */ 

typeof		: 'typeof';
questionType: 'questionType';
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




