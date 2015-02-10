grammar QL;


YESNO	: 'yes' | 'no';
NUMBER	: '-'?[0..9]+;
WS		: [\r\n\t ]+ -> skip;
IF		: 'if';
ELSE	: 'else';
TYPE	: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
ID		: ([a-zA-Z][a-zA-Z0-9]*);
TEXT	: '\"' .*? '\"';

COMMENT : '//' ~[\r\n]* -> skip;

// OPERATORS & EXPRESSIONS
fragment CALCOPERATOR	: '*' | '/'
						| '+' | '-'
						;
fragment ANDOROPERATOR	: '&&' | '||';
fragment NEQOPERATOR	: '==' | '!=';
fragment COMPAREOPERATOR: '>' | '>='
						| '<' | '<='
						;
OPERATOR				: CALCOPERATOR
						| ANDOROPERATOR
						| NEQOPERATOR
						| COMPAREOPERATOR
						;

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

ifStatement : 'if' '(' condition ')' block (('else' ifStatement)* | ('else' block)?) ';';
