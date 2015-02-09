grammar QL;

/*
 * Parser Rules
 */
YESNO: 'yes'|'no';
NUMBER: [\-]+[0..9]+;
WS2: [\r\n\t]+ -> skip;
TEXT: [\".*\"];



compileUnit
	:	EOF
	;

/*
 * Lexer Rules
 */

WS
	:	' ' -> channel(HIDDEN)
	;
