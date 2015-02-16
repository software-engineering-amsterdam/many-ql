grammar QL;
@members{
	
	void echo(Token id){}
}

/* PARSER RULES */
form 
	: FORM Identifier block
	;

block
	:	LBRACE statement* RBRACE
	;

statement
	: block
	| question
	| ifstatement
	;

// Question Declaration	
question : questionType questionName questionLabel SEMI;

questionType
	: builtinType
	| userType
	;
	
builtinType
	: INT
	| STR
	| BOOL
	| DATE
	| DEC
	| CUR
	;
	
userType
	: Cap_Start_Identifier
	;

questionName
	: Identifier {echo($Identifier);}
	;
	
questionLabel
	: StringLiteral
	;

// If statement
ifstatement
	:	IF LPAREN expression RPAREN statement (ELSE statement)?
	;

expression
	: Identifier
	| literal
	|	expression AND expression
	|	expression OR expression
	|	expression EQUAL expression
	|	expression NOTEQUAL expression
	|	expression ASSIGN expression
	|	expression GT expression
	|	expression LT expression
	|	expression GE expression
	|	expression LE expression
	|	expression ADD expression
	|	expression SUB expression
	|	expression MUL expression
	|	expression DIV expression
	| BANG expression
	;

literal
	: IntegerLiteral
	| StringLiteral
	| BooleanLiteral
	| DateLiteral
	| DecimalLiteral
	| CurrencyLiteral
	;

/* LEXER RULES */
// Keywords
FORM		:		'Form';
IF			:		'if';
ELSE		:		'else';


// Data Types
INT 		:		'Integer';
STR 		:		'String';
BOOL		:		'Boolean';
DATE		:		'Date';
DEC			:		'Decimal';
CUR 		:		'Currency';

// Symbols
SEMI		:		';';
LBRACE	:		'{';
RBRACE	:		'}';
LPAREN	: 	'(';
RPAREN	:		')';

// Operators
AND			:		'&&';
OR			:		'||';
EQUAL		:		'==';
NOTEQUAL:		'!=';
ASSIGN	:		'=';
GT			:		'>';
LT			:		'<';
GE			:		'>=';
LE			:		'<=';
ADD			:		'+';
SUB			:		'-';
MUL			:		'*';
DIV			:		'/';
BANG		:		'!';


// Literals
IntegerLiteral   // do we need this?
	: //Non_Zero_Digit Digit*
	;
	
StringLiteral
	: '"' .*? '"'
	;

BooleanLiteral
	: 'true'
	| 'false'
	;

DateLiteral
	:
	;

DecimalLiteral
	: [0]
	| [1-9][0-9]*
	;

CurrencyLiteral
	:
	;

Non_Zero_Digit
	: [1-9]
	;
	
Digit
	: [0-9]
	;
	
Cap_Start_Identifier
	: [A-Z][a-zA-Z0-9]*
	;
Identifier
	: [a-zA-Z][a-zA-Z0-9]*
	;
	
WHITE_SPACE
	: [ \t\r\n]+ -> skip
	;

