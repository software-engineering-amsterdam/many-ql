grammar QL;

// Definitions
YESNO		: 'yes' | 'no';
NUMBER		: '-'?[0-9]+; // note that this is only integer, does not include decimal maybe TODO
TEXT		: '\"' .*? '\"';
IDENTIFIER	: [a-zA-Z][a-zA-Z0-9]*;

// Ignore rules
WS			: [\r\n\t ]+ -> skip;
COMMENT		: '//' ~[\r\n]* -> skip;

// Operators
fragment NEQOPERATOR	: '=='  //should be defaultly usable by text, number, yesno
						| '!='  //should be defaultly usable by text, number, yesno
						;
fragment COMPAREOPERATOR: '>' | '>='  //should be defaultly usable by number
						| '<' | '<=' //should be defaultly usable by number
						;
fragment CALCOPERATOR	: '*' // number, yesno
						| '/' // number, except division by zero
						| '+' // number, yesno, text
						| '-' // number
						;
fragment ANDOROPERATOR	: '&&'  // if we use * and + for AND OR, we can abandon these
						| '||' 
						;
OPERATOR				: CALCOPERATOR
						| ANDOROPERATOR
						| COMPAREOPERATOR
						| NEQOPERATOR
						;

// Production rules
operator: OPERATOR;

type		: 'yesno'	# yesno
			| 'number'	# number
			| 'text'	# text
			;

literal		: YESNO
			| NUMBER
			| TEXT
			| IDENTIFIER
			;

unit		: questionUnit
			| statementUnit
			| controlUnit
			;

block		: '{' unit* '}';

formBlock	: 'form' IDENTIFIER block;

expression	: literal
			| '(' expression ')'
			| '(' expression operator expression ')'
			;

questionUnit  : 'question' IDENTIFIER '(' type ')' TEXT ';';
statementUnit : 'statement' IDENTIFIER '(' type ',' expression ')' TEXT ';'	;
controlUnit	  : 'if' expression block ('else' block)? ';';
