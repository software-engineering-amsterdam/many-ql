grammar QL;

/*
 * Parser Rules
 */
YESNO	: 'yes' | 'no';
NUMBER	: [-]?[0..9]+;
TEXT	: [\".*\"] | WS;
WS		: [\r\n\t]+ -> skip;

UNITTYPE: 'question' | 'statement';
ID		: ([a-zA-Z][a-zA-Z0-9]*);
TYPE	: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';

unit	: UNITTYPE ID '(' TYPE (',' ATTR)+ ')' TEXT
		| UNITTYPE ID '(' TYPE ',' TEXT ')' TEXT
		| UNITTYPE ID '(' TYPE ',' EXPR ')' TEXT
		;

/*
 * Lexer Rules
 */