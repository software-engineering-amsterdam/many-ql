grammar TaxForm;

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

FORM		: 'form';
IF			: 'if';

BOOLEAN		: 'boolean';
MONEY		: 'money';

arithmetic	: ( MINUS | ADD | MULTIPLY | DIVIDE );

varName		: CHAR+;
varType		: (BOOLEAN | MONEY);

//question	: '"' CHAR+ (DIGIT+)? ('?'|':')? '"';
question	: STRING (DIGIT+)? ('?'|':')?;
answer		: varName COLON varType ( ASSIGN LPAREN? varName arithmetic varName RPAREN? )?;
qna			: question answer;

condition	: CHAR+;
iF			: IF LPAREN condition RPAREN LBRACE qna+ RBRACE;

formName	: CHAR+;
form		: FORM formName LBRACE (iF | qna+)+ RBRACE;

WS: [ \t\r\n]+ -> skip;

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