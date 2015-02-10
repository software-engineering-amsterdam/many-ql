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
// Strange combinations should be handled at other level  "abc"||"213"
fragment NEQOPERATOR	: '=='  //should be defaultly usable by text, number, yesno
						| '!=';
fragment COMPAREOPERATOR: '>' | '>='  //should be defaultly usable by number
						| '<' | '<='
						;
fragment CALCOPERATOR	: '*' | '/'  //should be defaultly usable by number
						| '+' | '-' //+- could be usable by yesno and +possibly by text
						;
fragment ANDOROPERATOR	: '&&' | '||';  //should be defaultly usable by yesno
OPERATOR		: CALCOPERATOR
				| ANDOROPERATOR
				| COMPAREOPERATOR
				| NEQOPERATOR
				;

// Production rules
unit	: UNITTYPE ID '(' TYPE (',' ATTR)* ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' TEXT ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' expression ')' TEXT ';'
		| ifStatement;

block: '{' unit* '}';

formBlock: 'form' ID block;

expression		: '(' (expression | condition) ')';
condition		: NUMBER OPERATOR NUMBER
				| YESNO OPERATOR YESNO
				| TEXT OPERATOR TEXT
				;

ifStatement : 'if' '(' condition ')' block ('else' ifStatement)* ('else' block)? ';';
