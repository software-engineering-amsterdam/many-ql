grammar QL;


@parser::header
{
	import org.uva.sea.ql.model.expression.*;
	import org.uva.sea.ql.model.expression.commonexpression.*;
	import org.uva.sea.ql.model.expression.booleanexpression.*;
	import org.uva.sea.ql.model.expression.mathexpression.*;
	import org.uva.sea.ql.model.literal.*;
	import org.uva.sea.ql.model.value.*;
}

@lexer::header
{
//	import org.uva.sea.ql.model.expression.*;
//	import org.uva.sea.ql.model.expression.mathexpression.*;
//	import org.uva.sea.ql.model.expression.booleanexpression.*;
//	import org.uva.sea.ql.model.expression.commonexpression.*;
}

// Parser rules
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

ifStatement : IF LEFT_PARENTHESES expr RIGHT_PARENTHESES block elseIfStatement* elseStatement?;

elseIfStatement : ELIF block elseStatement;

elseStatement : ELSE block;

expr: 
	literal
	| expr AND expr
	| expr OR expr
	| expr EQUAL_COND expr
	| expr GREATER expr
	| expr EQUAL_GREATER expr
	| expr EQUAL expr
	| expr EQUAL_SMALLER expr
	| expr SMALLER expr
	| expr PLUS expr 
	| expr MINUS expr 
	| expr MULTIPLY expr 
	| expr DEVIDE expr 
;
//=========================================


literal
 	 : Identifier
	 | IntegerLiteral
	 | DecimalLiteral
 	 | BooleanLiteral
 	 | StringLiteral
 	 | DateLiteral
	 ;


// Lexer rules

// Data Types
INT:			'Int';
STR:			'Str';
CUR:			'Cur';
BOOL:			'Bool';
DEC:			'Dec';
DATE:			'Date';


// Keywords
FORM		:		'form';
IF			:		'if';
THEN		:		'then';
ELSE		:		'else';
ELIF		:		'else if';

// Operators
OR:				'||';
AND:			'&&';
EQUAL:			'=';
GREATER: 		'>';
EQUAL_GREATER: 	'>='; 
EQUAL_COND:		'==';
EQUAL_SMALLER: 	'<=';
SMALLER: 		'<';
PLUS:			'+';
MINUS:			'-';
DEVIDE:			'/';
MULTIPLY:		'*';

// Symbols
LEFT_BRACE:	'{';
RIGHT_BRACE:	'}';
LEFT_PARENTHESES:	'(';
RIGHT_PARENTHESES:	')';
COLON:			':';
SEMICOLON:		';';


IntegerLiteral: [1-9][0-9]*;

DecimalLiteral: DecimalNumeral '.' Digit*;

DecimalNumeral : Non_Zero_Digit Digit* | [0];

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' .*? '"';

DateLiteral : Day '-' Month '-' Year;

Day: [Digit{2}];

Month: [Digit{2}];

Year: [Digit{4}];

Non_Zero_Digit: [1-9];
	
Digit: [0-9];

//Date: ('0');

WhiteSpace  :(' ' | '\t' | '\n' | '\r') -> skip;

MultiComment : '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;


