grammar QL;

/*  PARSER RULES  */

questionnaire: form*;

form : FORM Identifier block;

block : LEFT_BRACE statement* RIGHT_BRACE;

statement
	: ifStatement		
	| question			
	;

ifStatement
	: IF LEFT_PAREN expression RIGHT_PAREN block ELSE block		#IfElse
	| IF LEFT_PAREN expression RIGHT_PAREN block				#If
	;
	
question
	: questionName COLON questionLabel questionType LEFT_PAREN expression RIGHT_PAREN	#QuestCompute
	| questionName COLON questionLabel questionType										#QuestNormal
	;

questionType: INT | STR | BOOL;
questionName: Identifier;
questionLabel: StringLiteral;

expression
	: NOT 			expression					#ExprNot
	| PLUS			expression					#ExprPositive
	| MINUS 		expression					#ExprNegative
	| expression 	PLUS 			expression	#ExprPlus
	| expression 	MINUS 			expression	#ExprMinus
	| expression 	MULTIPLY 		expression	#ExprMultiply
	| expression 	DIVIDE 			expression	#ExprDivide
	| expression 	AND 			expression	#ExprAnd
	| expression 	OR 				expression	#ExprOr
	| expression 	EQUAL 			expression	#ExprEqual
	| expression 	NOTEQUAL		expression	#ExprNotEqual
	| expression 	GREATER 		expression	#ExprGreater
	| expression 	GREATER_EQUAL	expression	#ExprGreaterEqual
	| expression 	LESS 			expression	#ExprLess
	| expression 	LESS_EQUAL 		expression	#ExprLessEqual
	| LEFT_PAREN 	expression 		RIGHT_PAREN	#ExprParentheses
	| literal									#ExprLiteral
	;

literal
 	 : Identifier			#LiteralId
	 | IntegerLiteral		#LiteralInt
 	 | BooleanLiteral		#LiteralBool
 	 | StringLiteral		#LiteralStr
	 ;

/* LEXER RULES */
// Keywords		==================================================================
FORM: 			'form';
IF: 			'if';
ELSE: 			'else';

// DataTypes	==================================================================
INT: 			'Int';
STR: 			'Str';
BOOL: 			'Bool';

// Operators	==================================================================
NOT: 			'!';
PLUS: 			'+';
MINUS: 			'-';
MULTIPLY: 		'*';
DIVIDE: 		'/';
AND: 			'&&';
OR: 			'||';
EQUAL: 			'==';
NOTEQUAL:		'!=';
GREATER: 		'>';
GREATER_EQUAL:	'>='; 
LESS:			'<';
LESS_EQUAL: 	'<=';

// Symbols		==================================================================
LEFT_BRACE: 	'{';
RIGHT_BRACE: 	'}';
LEFT_PAREN: 	'(';
RIGHT_PAREN: 	')';
COLON: 			':';

IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

WhiteSpace: (' ' | '\t' | '\n' | '\r') -> skip;

MultiComment: '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
