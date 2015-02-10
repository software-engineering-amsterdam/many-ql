grammar QL;


@parser::header
{
}

@lexer::header
{
}

// Parser rules
form : question (question | statement)*;


question: questionType identifier stringLiteral SEMICOLON;

statement:	IF LEFT_PARENTHESES expr RIGHT_PARENTHESES LEFT_BRACES (question)+ RIGHT_BRACES;

expr: literal
	| expr AND expr
	| expr OR expr
	| expr EQUAL expr
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

questionType :INT | STR | CUR | BOOL;

identifier:	Ident;

literal
	 : numberLiteral
 	 | booleanLiteral
 	 | stringLiteral
 	 | identifier
	;
	
booleanLiteral: 
	bool;

numberLiteral
	: Int
	| Float
	;

stringLiteral
	: Str
	;

bool: TRUE | FALSE;


// Lexer rules
// Tokens

INT:			'Int';
STR:			'Str';
CUR:			'Cur';
BOOL:			'Bool';
TRUE: 			'true';
FALSE: 			'false';
IF: 			'if';
OR:				'||';
AND:			'&&';
EQUAL:			'=';
GREATER: 		'>';
EQUAL_GREATER: 	'>='; 
EQUAL_COND:		'==';
EQUAL_SMALLER: 	'<=';
SMALLER: 		'<';
LEFT_BRACES:	'{';
RIGHT_BRACES:	'}';
LEFT_PARENTHESES:	'(';
RIGHT_PARENTHESES:	')';
COLON:			':';
SEMICOLON:		';';
PLUS:			'+';
MINUS:			'-';
DEVIDE:			'/';
MULTIPLY:		'*';

Int: [0-9]+;

Str: '"' .*? '"';

Float: Int'.'Int;

//Date: ('0');

WhiteSpace  :(' ' | '\t' | '\n' | '\r') -> skip;

MultiComment : '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Ident: [a-zA-Z][a-zA-Z0-9_]*;


