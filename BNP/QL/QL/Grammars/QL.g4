grammar QL;

// Definitions
YESNO	: 'yes' | 'no';
NUMBER	: '-'?[0-9]+;
IF		: 'if';
ELSE	: 'else';
TYPE	: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
ID		: ([a-zA-Z][a-zA-Z0-9]*);
TEXT	: '\"' .*? '\"';

// Ignore rules
WS		: [\r\n\t ]+ -> skip;
COMMENT : '//' ~[\r\n]* -> skip;

// Operators & expressions
		 NEQOPERATOR	: '==' | '!=';
fragment COMPAREOPERATOR: '>' | '>='
						| '<' | '<='
						| NEQOPERATOR
						;
fragment CALCOPERATOR	: '*' | '/'
						| '+' | '-'
						;
fragment ANDOROPERATOR	: '&&' | '||';
		 OPERATOR		: CALCOPERATOR
						| ANDOROPERATOR
						| COMPAREOPERATOR
						;

// Production rules
unit	: UNITTYPE ID '(' TYPE (',' ATTR)* ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' TEXT ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' expression ')' TEXT ';'
		| ifStatement;

block: '{' unit* '}';

formBlock: 'form' ID block;

expression		: '(' (expression | condition) ')';
condition		: NUMBER OPERATOR NUMBER ;
				| YESNO NEQOPERATOR YESNO
				| TEXT NEQOPERATOR TEXT
				;

ifStatement : 'if' '(' condition ')' block ('else' ifStatement)* ('else' block)? ';';
