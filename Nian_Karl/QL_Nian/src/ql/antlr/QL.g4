grammar QL;

/*  PARSER RULES  */
form : FORM Identifier block;

block : LEFT_BRACE statement* RIGHT_BRACE;

statement
	: block
	| question
	| ifStatement
	;
	
question : questionType questionName questionLabel SEMICOLON;

questionType :INT | STR | CUR | BOOL | DEC | DATE;

questionName : Identifier;

questionLabel : StringLiteral;

ifStatement : IF LEFT_PAREN expression RIGHT_PAREN block (ELSE block)?;

//ifStatement : IF LEFT_PARENTHESES expression RIGHT_PARENTHESES block elseIfStatement* elseStatement?;
//
//elseIfStatement : ELIF block elseStatement;
//
//elseStatement : ELSE block;

expression
	: literal								#ExprLiteral
	| expression 	AND 		expression	#ExprAnd
	| expression 	OR 			expression	#ExprOr
	| expression 	EQUAL 		expression	#ExprEqual
	| expression 	GREATER 	expression	#ExprGreater
	| expression 	GREAT_EQUAL	expression	#ExprGreaterEqual
	| expression 	ASSIGN 		expression	#ExprAssign
	| expression 	LESS_EQUAL 	expression	#ExprLessEqual
	| expression 	LESS 		expression	#ExprLess
	| expression 	PLUS 		expression	#ExprPlus
	| expression 	MINUS 		expression	#ExprMinus
	| expression 	MULTIPLY 	expression	#ExprMultiply
	| expression 	DEVIDE 		expression	#ExprDevide
	| LEFT_PAREN 	expression 	RIGHT_PAREN	#ExprParentheses
	;

literal
 	 : Identifier
	 | IntegerLiteral
	 | DecimalLiteral
 	 | BooleanLiteral
 	 | StringLiteral
 	 | DateLiteral
	 ;

/* LEXER RULES */
// Keywords		==================================================================
FORM		:		'form';
IF			:		'if';
THEN		:		'then';
ELSE		:		'else';
ELIF		:		'else if';

// DataTypes	==================================================================
INT 		:		'Int';
STR			:		'Str';
CUR			:		'Cur';
BOOL		:		'Bool';
DEC			:		'Dec';
DATE		:		'Date';

// Operators	==================================================================
OR			:		'||';
AND			:		'&&';
ASSIGN		:		'=';
EQUAL		:		'==';
GREATER		: 		'>';
LESS		: 		'<';
GREAT_EQUAL	: 		'>='; 
LESS_EQUAL	: 		'<=';
PLUS		:		'+';
MINUS		:		'-';
DEVIDE		:		'/';
MULTIPLY	:		'*';

// Symbols		==================================================================
LEFT_BRACE	:		'{';
RIGHT_BRACE	:		'}';
LEFT_PAREN	:		'(';
RIGHT_PAREN	:		')';
COLON		:		':';
SEMICOLON	:		';';

IntegerLiteral: [1-9][0-9]*;

DecimalLiteral: DecimalNumeral '.' Digit*;

DecimalNumeral : Non_Zero_Digit Digit* | [0];

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

DateLiteral : Day '-' Month '-' Year;

Day: [Digit{2}];

Month: [Digit{2}];

Year: [Digit{4}];

Non_Zero_Digit: [1-9];
	
Digit: [0-9];

WhiteSpace  :(' ' | '\t' | '\n' | '\r') -> skip;

MultiComment : '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
