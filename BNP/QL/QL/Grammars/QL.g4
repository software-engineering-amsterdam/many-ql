grammar QL;

/*
 * Parser Rules
 */
YESNO: 'yes'|'no';
NUMBER: [\-]+[0..9]+;
TEXT: [\".*\"];



compileUnit
	:	EOF
	;

/*
 * Lexer Rules
 */
 WS: [ \r\n\t]+ -> skip;