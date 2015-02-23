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
	| expression 	DIVIDE 		expression	#ExprDivide
	| LEFT_PAREN 	expression 	RIGHT_PAREN	#ExprParentheses
	;

literal
 	 : Identifier			#Id
	 | IntegerLiteral		#Int
 	 | BooleanLiteral		#Bool
 	 | StringLiteral		#Str
	 ;

/* LEXER RULES */
// Keywords		==================================================================
FORM		:		'form';
IF			:		'if';
THEN		:		'then';
ELSE		:		'else';

// DataTypes	==================================================================
INT 		:		'Int';
STR			:		'Str';
BOOL		:		'Bool';

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
DIVIDE		:		'/';
MULTIPLY	:		'*';

// Symbols		==================================================================
LEFT_BRACE	:		'{';
RIGHT_BRACE	:		'}';
LEFT_PAREN	:		'(';
RIGHT_PAREN	:		')';
COLON		:		':';

IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

WhiteSpace  :(' ' | '\t' | '\n' | '\r') -> skip;

MultiComment : '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;
