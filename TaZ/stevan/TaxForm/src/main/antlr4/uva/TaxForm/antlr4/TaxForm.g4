grammar TaxForm;

/* Lexical rules */
//ESC_SEQ 	: '\\' ('b' | 't' | 'n' | 'f' | 'r' | '\"' | '\'' | '\\');
//STRING		: '"'  ( ESC_SEQ | ~('\\'|'"') )* '"';
STRING		: '"' ( '\\"' | '\\\\' | ~["\\] )* '"' ;
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

IF			: 'if' ;
FORM		: 'form' ;

ID
	: [a-z] [a-zA-Z0-9]*
	;



/* Grammar rules */
qna			: question answer ;
question	: STRING (DIGIT+)? ('?'|':')? ;
answer		: varName COLON varType ( ASSIGN LPAREN? expression RPAREN? )? ;
varName		: ID ;
varType		: ID ;

taxForm
	: FORM atom LBRACE (qna | statement)+ RBRACE
	;
	
statement	
	: if_statement
	;

if_statement
	: IF condition LBRACE (qna | statement)+ RBRACE
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
	| LPAREN expression RPAREN    		# expressionAtom
	;


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