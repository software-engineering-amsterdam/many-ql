grammar QL;

// Definitions
YESNO		: 'yes' | 'no';
NUMBER		: [0-9]+; // note that this is only integer, does not include decimals
TEXT		: '\"' .*? '\"';
IDENTIFIER	: [a-zA-Z][a-zA-Z0-9]*;

// Ignore rules
WS			: [\r\n\t ]+	-> skip;
COMMENT		: '//' ~[\r\n]* -> skip;

// Operators
EQUALS				: '==';	//should be defaultly usable by text, number, yesno
NOTEQUALS			: '!=';	//should be defaultly usable by text, number, yesno
GREATERTHAN			: '>';	//should be defaultly usable by number
GREATERTHANOREQUALTO: '>=';	//should be defaultly usable by number
LESSTHAN			: '<';	//should be defaultly usable by number
LESSTHANOREQUALTO	: '<=';	//should be defaultly usable by number
MULTIPLICATION		: '*';	// number, yesno
DIVISION			: '/';	// number, except division by zero
ADDITION			: '+';	// number, yesno, text
SUBTRACTION			: '-';	// number
AND					: '&&';
OR					: '||';

operatorEquals					:EQUALS;
operatorNotEquals				:NOTEQUALS;
operatorGreaterThan				:GREATERTHAN;
operatorGreaterThanOrEqualTo	:GREATERTHANOREQUALTO;
operatorLessThan				:LESSTHAN;
operatorLessThanOrEqualTo		:LESSTHANOREQUALTO;
operatorMultiplication			:MULTIPLICATION;
operatorDivision				:DIVISION;
operatorAddition				:ADDITION;
operatorSubtraction				:SUBTRACTION;
operatorAnd						:AND;
operatorOr						:OR;

// Production rules
operator	: operatorEquals
			| operatorNotEquals
			| operatorGreaterThan
			| operatorGreaterThanOrEqualTo
			| operatorLessThan
			| operatorLessThanOrEqualTo
			| operatorMultiplication
			| operatorDivision
			| operatorAddition
			| operatorSubtraction
			| operatorAnd
			| operatorOr
			;

type		: 'yesno'	# yesnoType
			| 'number'	# numberType
			| 'text'	# textType
			;

yesno:		YESNO;
number:		'-' NUMBER | NUMBER;
text:		TEXT;
identifier:	IDENTIFIER;


literal		: yesno
			| number
			| text
			| identifier
			;

unit		: questionUnit
			| statementUnit
			| controlUnit
			;

block		: '{' unit* '}';

formBlock	: 'form' identifier block;

expression	: literal
			| '(' expression ')'
			| '(' expression operator expression ')'
			;

questionUnit  : 'question' identifier '(' type ')' TEXT ';';
statementUnit : 'statement' identifier '(' type ',' expression ')' TEXT ';'	;
controlUnit	  : 'if' expression block ('else' block)? ';';
