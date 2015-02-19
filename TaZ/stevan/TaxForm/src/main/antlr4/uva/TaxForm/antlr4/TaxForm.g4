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

question : label varName ':' ( varType | computed ) ;

computed : varType ( ASSIGN '(' expression ')' ) ;

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
	: 'if' '(' expression ')' '{' ( question | condition )+ '}'	
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
expression
	: varName													#singleExpression
	| varName AND varName										#andExpression
	| varName OR varName										#orExpression
	| varName NOT varName										#notExpression
	| varName LOWER varName										#lowerExpression
	| varName UPPER varName										#upperExpression
	| varName LOWER_EQUAL varName								#lowerEqualExpression
	| varName UPPER_EQUAL varName								#upperEqualExpression
	| varName EQUAL varName										#equalExpression
	| varName NOT_EQUAL varName									#notEqualExpression
	| varName DIVIDE varName									#divideExpression
	| varName MINUS varName										#minusExpression
	| varName ADD varName										#addExpression
	| varName MULTIPLY varName									#multiplyExpression
	| varName DIVIDE varName									#divideExpression
	;


/*
// Lexical rules
//ESC_SEQ 	: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
//STRING		: '"'  ( ESC_SEQ | ~('\\'|'"') )* '"';
STRING		: '"' ( '\\"' | '\\\\' | ~["\\] )* '"' ;
DIGIT		: [0-9];
ASSIGN		: '=';
MINUS		: '-';
ADD			: '+';
MULTIPLY	: '*';
DIVIDE		: '/';
COMMENT 	: '//' .+? ('\n'|EOF) -> skip ;
WS			: [ \t\r\u000C\n]+ -> skip ;
NEW_LINE	: '\r'? '\n';
TRUE		: 'TRUE'  | 'true'  | 'YES' | 'yes';
FALSE		: 'FALSE' | 'false' | 'NO'  | 'no';
BOOLEAN
	: TRUE
	| FALSE
	;

INT
	: DIGIT+
	;

FLOAT
	: DIGIT+ [.,] DIGIT*
	| DIGIT* [.,] DIGIT+
	;

ID
	: [a-z] [a-zA-Z0-9]*
	;

// Grammar rules 
qna			: question answer ;
question	: STRING (DIGIT+)? ('?'|':')? ;
answer		: varName ':' varType ( ASSIGN '('? expression ')'? )? ;
varName		: ID ;
varType		: ID ;

taxForm
	: 'form' ID '{' (qna | statement)+ '}'
	;
	
statement
	: 'if' condition '{' (qna | statement)+ '}'		# ifStatement
	;

condition
	: expression
	;

expression
	: atom								# atomExpression
	| expression MINUS expression		# minusExpression
	;

atom
	: INT								# integerAtom
	| FLOAT								# floatAtom
	| BOOLEAN							# boolAtom
	| ID								# idAtom
	| STRING							# stringAtom
	| '(' expression ')'	    		# expressionAtom
	;
*/

/*
fragment ESC_SEQ : '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
STRING		: '"'  ( ESC_SEQ | ~('\\'|'"') )* '"';
//CHAR		: '\'' ( ESC_SEQ | ~('\''|'\\') ) '\'';

CHAR		: [a-zA-Z];
DIGIT		: [0-9];
LBRACE		: '{';
RBRACE		: '}';
LPAREN		: '(';
RPAREN		: ')';
ASSIGN		: '=';
MINUS		: '-';
ADD			: '+';
MULTIPLY	: '*';
DIVIDE		: '/';
COLON		: ':';

//FORM		: 'form';
IF			: 'if';

BOOLEAN		: 'boolean';
MONEY		: 'money';

arithmetic	: ( MINUS | ADD | MULTIPLY | DIVIDE );

varName		: CHAR+ ;
varType		: (BOOLEAN | MONEY);

//question	: '"' CHAR+ (DIGIT+)? ('?'|':')? '"';
question	: STRING (DIGIT+)? ('?'|':')?;
answer		: varName COLON varType ( ASSIGN LPAREN? varName arithmetic varName RPAREN? )?;
qna			: question answer;

condition	: CHAR+;
iF			: IF LPAREN condition RPAREN LBRACE qna+ RBRACE;

formName	: CHAR+;
form		: 'form' formName LBRACE (iF | qna+)+ RBRACE;

WS: [ \t\r\n]+ -> skip;
 */


/*
DIGIT			: [0-9];
CHAR			: [a-zA-Z];
LCHAR			: [a-z];
UCHAR			: [A-Z];
ESC_SEQ 		: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
COLON           : ':';

LOWER                : '<';
LOWER_EQUAL          : '<=';
UPPER                : '>';
UPPER_EQUAL          : '>=';
ASSIGN               : '=';
EQUAL                : '==';
NOT                  : '!';
NOT_EQUAL            : '!=';
ADD                  : '+';
ADD_TO_PREVIOUS      : '+=';
INCREMENT            : '++';
MINUS                : '-';
MINUS_FROM_PREVIOUS  : '-=';
DECREMENT            : '--';
MULTIPLY             : '*';
MULTIPLY_TO_PREVIOUS : '*=';
DIVIDE               : '/';
DIVIDE_FROM_PREVIOUS : '/=';
MODE                 : '%';
SEMICOLON            : ';';
COMMA                : ',';

//The language supports booleans, integers and string values.
//BOOLEAN			: 'True'|'False';
INT				: DIGIT+;

String			: '"' ( ESC_SEQ | ~('\\'|'"') )* '"';
UnString		: CHAR+;

FORM			: 'form';
BOOLEAN			: 'boolean';
MONEY			: 'money';

variableName	: LCHAR CHAR+;
variableType	: ( BOOLEAN | MONEY );

question	: String '?'? COLON?;
answer		: variableName COLON variableType;

formName	: UnString;
form		: 	FORM formName LBRACE 
					(question answer)+ 
				RBRACE;

WS: [ \t\r\n]+ -> skip;
*/