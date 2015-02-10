grammar QL;

// Definitions
YESNO	: 'yes' | 'no';
NUMBER	: '-'?[0-9]+;
IF		: 'if';
ELSE	: 'else';
TYPE	: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
ID		: [a-zA-Z][a-zA-Z0-9]*;
TEXT	: '\"' .*? '\"';

// Ignore rules
WS		: [\r\n\t ]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;

// Operators & expressions
// Strange combinations should be handled at other level(type checker?)  "abc"*"213"
fragment NEQOPERATOR	: '=='  //should be defaultly usable by text, number, yesno
						| '!='; //should be defaultly usable by text, number, yesno
fragment COMPAREOPERATOR: '>' | '>='  //should be defaultly usable by number
						| '<' | '<=' //should be defaultly usable by number
						;
fragment CALCOPERATOR	: '*' // number, yesno
						| '/' // number, except division by zero
						| '+' // number, yesno, text
						| '-' // number
						
						;
fragment ANDOROPERATOR	: '&&' | '||';  // if we use * and + for AND OR, we can abandon these
OPERATOR		: CALCOPERATOR
				| ANDOROPERATOR
				| COMPAREOPERATOR
				| NEQOPERATOR
				;

// Production rules
unit	: UNITTYPE ID '(' TYPE (',' ATTR)* ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' TEXT ')' TEXT ';'		//this 
		| UNITTYPE ID '(' TYPE ',' expression ')' TEXT ';'	//and this could be merged 
		//| UNITTYPE ID '(' TYPE ',' statement ')' TEXT ';'	//to this
		//because of the usage

		| ifStatement;

block: '{' unit* '}';

formBlock: 'form' ID block;

//what's the use of expression?
//to handle some input and provide somehow altered(or not) output.
// our expression should be basically a function. 
expression		: ('(' ( expression | condition) ')');

//what use does the "condition" have?
//so this should be a function returning a boolean value
condition		: NUMBER OPERATOR NUMBER
				| YESNO OPERATOR YESNO
				| TEXT OPERATOR TEXT
				;
/*
i think about creation of something that replaces the expression and condition like this:

functionDefinition	: '(' function OPERATOR function ')';
typeDefinition		: NUMBER
					| TEXT 
					| YESNO;
statement : functionDefinition | typeDefinition;


Statement should replace condition and expression
*/
ifStatement : 'if' '(' condition ')' block ('else' ifStatement)* ('else' block)? ';';
