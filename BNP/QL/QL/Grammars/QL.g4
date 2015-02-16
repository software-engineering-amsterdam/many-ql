grammar QL;

// Definitions
YESNO	: 'yes' | 'no';
NUMBER	: '-'?[0-9]+;
IF		: 'if';
ELSE	: 'else';
TYPENAME: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
ID		: [a-zA-Z][a-zA-Z0-9]*;
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

// Production rules
typedef		: YESNO
			| NUMBER
			| TEXT
			;

typedefext	: typedef
			| ID
			;

unit		: UNITTYPE ID '(' TYPENAME (',' ATTR)* ')' TEXT ';'
			| UNITTYPE ID '(' TYPENAME ',' (typedef|expression) ')' TEXT ';'
			| ifStatement
			;

block		: '{' unit* '}';

formBlock	: 'form' ID block;

//to handle some input and provide somehow altered(or not) output.
// our expression should be basically a function. 
//expression		: ('(' ( expression | condition) ')');

expression	: '(' expression | ((typedefext OPERATOR)+ typedefext) ')';

ifStatement	: 'if' expression block ('else' ifStatement)* ('else' block)? ';';
