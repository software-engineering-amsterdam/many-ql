grammar QL;

// Definitions
YESNO	: 'yes' | 'no';
NUMBER	: '-'?[0-9]+; // note that this is only integer, does not include decimal maybe TODO
IF		: 'if';
ELSE	: 'else';
TYPENAME: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
IDENTIFIER		: [a-zA-Z][a-zA-Z0-9]*;
TEXT	: '\"' .*? '\"';

// Ignore rules
WS		: [\r\n\t ]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;

// Operators & expressions
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

operator: OPERATOR;

// Production rules
typedef		: YESNO
			| NUMBER
			| TEXT
			;

typeDefExt	: typedef
			| IDENTIFIER
			;


unit		: UNITTYPE IDENTIFIER '(' TYPENAME (',' ATTR)* ')' TEXT ';'
			| UNITTYPE IDENTIFIER '(' TYPENAME ',' (typedef|expression) ')' TEXT ';'
			| controlBlock
			;

block		: '{' unit* '}';

formBlock	: 'form' IDENTIFIER block;

//to handle some input and provide somehow altered(or not) output.
// our expression should be basically a function. 
//expression		: ('(' ( expression | condition) ')');


expression	: typeDefExt
			| (
				'('	( typeDefExt 
					| expression 
					|  (expression operator expression) 
					) 
				')');


controlBlock	: 'if' expression block ('else' controlBlock)* ('else' block)? ';';
