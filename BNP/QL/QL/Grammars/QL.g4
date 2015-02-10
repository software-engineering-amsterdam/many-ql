grammar QL;

YESNO	: 'yes' | 'no';
NUMBER	: [-]?[0..9]+;
WS		: [\r\n\t ]+ -> skip;
IF: 'if';
ELSE: 'else';
TYPE	: 'yesno' | 'number' | 'text';
ATTR	: 'required' | 'optional';
UNITTYPE: 'question' | 'statement';
TEXT	: [\".*\"] | WS;
ID		: ([a-zA-Z][a-zA-Z0-9]*);


unit	: UNITTYPE ID '(' TYPE (',' ATTR)+ ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' TEXT ')' TEXT ';'
		| UNITTYPE ID '(' TYPE ',' expression ')' TEXT ';'
		| ifStatement;

block: '{' unit* '}';

formBlock: 'form' ID block;

ifStatement : 'if' '(' condition ')' block ( 'else' (ifStatement | block ))?;  

condition: '';
expression: '';