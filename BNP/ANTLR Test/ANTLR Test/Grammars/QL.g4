grammar QL;

/*
 * Lexer Rules
 */

WS // Whitespace
	: (' ' | '\t' | '\r' | '\n')+ 
	-> channel(HIDDEN)
	;

SALUTATION
	: 'Hello'
	;

HELLO_OR_BYE
	: SALUTATION | 'Bye'
	;

ANY_CHARACTER 
	: (.)
	;

NUMBER
	: '0'..'9';

NUMBERS
	: (NUMBER)+
	;

NUMBER_NO_LEADING_ZEROS
	: '0'..'9' | (('1'..'9')('0'..'9')+)
	;

EVERYTHING
	: (.)*?
	;

ONE_OR_TWO_DIGITS
	: ('0'..'9')('0'..'9')?
	;

NOT_A_DIGIT
	: ~'0'..'9'
	;


/*
 * Parser Rules
 * START WITH A LOWERCASE LETTER TO BE INTERPRETED AS A PARSER
 */

compileUnit
	:	EOF
	;

postCode
	: NUMBERS SALUTATION
	;