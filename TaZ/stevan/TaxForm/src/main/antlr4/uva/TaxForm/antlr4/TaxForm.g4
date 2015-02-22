grammar TaxForm;

/* Lexical rules */
//ESC_SEQ 	: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
//STRING		: '"'  ( ESC_SEQ | ~('\\'|'"') )* '"';

DIGIT		: [0-9] ;

LOWER		: '<' ;
UPPER		: '>' ;
LOWER_EQUAL	: '<=' ;
UPPER_EQUAL	: '>=' ;
EQUAL		: '==' ;
NOT_EQUAL	: '!=' ;

AND			: '&&' ;
OR			: '||' ;
NOT			: '!' ;

ASSIGN		: '=' ;
MINUS		: '-' ;
ADD			: '+' ;
MULTIPLY	: '*' ;
DIVIDE		: '/' ;
/*
TRUE		: 'TRUE'  | 'true'  | 'YES' | 'yes' ;
FALSE		: 'FALSE' | 'false' | 'NO'  | 'no' ;

BOOLEAN
	: TRUE
	| FALSE
	;
 */
 
BOOLEAN		: 'boolean' ;
STRING		: '"' ( '\\"' | '\\\\' | ~["\\] )* '"' ;
INT			: DIGIT+ ;
//DATE		:  ;
FLOAT
	: DIGIT+ [.,] DIGIT*
	| DIGIT* [.,] DIGIT+
	;
MONEY		: 'money' ;

ID	: [a-z] [a-zA-Z0-9]* ;
	
COMMENT 	: '//' .+? ('\n'|EOF) -> skip ;
WS			: [ \t\r\u000C\n]+ -> skip ;
NEW_LINE	: '\r'? '\n';

/* Grammar rules */
/*
 * A questionnaire consists of a number of questions arranged in sequential and conditional
 * structures, and grouping constructs.
 * 
 * Sequential composition prescribes the order of presentation.
 */
form : 'form' varName '{' ( question | condition )+ '}' ;

/* 
 * QL consists of questions grouped in a top-level form construct. 
 * First, each question is identified by a name that at the same time represents the result 
 * of the question. In other words the name of the question is also the variable that holds 
 * the answer.
 * 
 * Second, a question has a label that contains the actual question text presented to the user.
 * 
 * Third, every question has a type.
 * 
 * Finally, a question can optionally be associated to an expression: this makes the question 
 * computed.
 */
label : STRING (DIGIT+)? ('?'|':')? ;
varName : ID ;
varType : ( BOOLEAN | MONEY | INT | STRING ) ;

question : label varName ':' (varType | computed)? ;

computed : varType ASSIGN '(' allMighty+ ')' ;

/*
 * Conditional structures associate an enabling condition to a question, in which
 * case the question should only be presented to the user if and when the condition becomes
 * true.
 * 
 * The expression language used in conditions is the same as the expressions used in computed 
 * questions.
 * 
 * Grouping does not have any semantics except to associate a single condition to multiple 
 * questions at once.
 */
condition 
	: 'if' '(' allMighty+ ')' '{' ( question | condition )+ '}'	
		(
			('else' '{' ( question | condition )+ '}')
			|
			('else' condition)+
		)? #ifCondition
	;

/*
 * For expressions we restrict ourselves to booleans (e.g., && , || and ! ), comparisons ( < ,
 * > , >= , <= , != and == ) and basic arithmetic ( + , - , * and / ). The required types are:
 * boolean, string, integer, date and decimal and money/currency.
 */
 
allMighty
	: expression
	;
	
expression
	: varName											#singleExpression
	| AND allMighty										#andExpression
	| OR allMighty										#orExpression
	| NOT allMighty										#notExpression
	| LOWER allMighty									#lowerExpression
	| UPPER allMighty									#upperExpression
	| LOWER_EQUAL allMighty								#lowerEqualExpression
	| UPPER_EQUAL allMighty								#upperEqualExpression
	| EQUAL allMighty									#equalExpression
	| NOT_EQUAL allMighty								#notEqualExpression
	| MINUS allMighty									#minusExpression
	| ADD allMighty										#addExpression
	| MULTIPLY allMighty								#multiplyExpression
	| DIVIDE allMighty									#divideExpression
	;

