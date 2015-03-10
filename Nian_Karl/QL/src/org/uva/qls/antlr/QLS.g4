grammar QLS;

style: STYLE Identifier page*;

page: PAGE Identifier block;

block: LEFT_PAREN section* RIGHT_PAREN;

section: SECTION StringLiteral LEFT_PAREN questionIdent RIGHT_PAREN;

questionIdent:QUESTION Identifier ;

styling: WIDGET COLON widget
	| WIDTH COLON IntegerLiteral
	| HEIGHT COLON IntegerLiteral
	| FONTSIZE COLON IntegerLiteral
	| FONT COLON font
	| COLOR COLON RgbValue
	;

font: ARIAL;

widget: 	TEXT
	| CHECKBOX
	| SPINBOX COLON LEFT_BRACKET IntegerLiteral (COMMA IntegerLiteral)+ RIGHT_BRACKET
	| SLIDER COLON LEFT_BRACKET IntegerLiteral (COMMA IntegerLiteral)+ RIGHT_BRACKET
	| DROPDOWN COLON trueFalseIdentifier
	| RADIO COLON trueFalseIdentifier
	;

trueFalseIdentifier: (trueLabel = Identifier | falseLabel = Identifier ) NewLine;

/* LEXER RULES */

//Keywords
STYLE:		 	'style';
PAGE: 			'page';
SECTION:		'section';
QUESTION: 		'question';

//Styling keywords
WIDGET:			'widget';
SLIDER:			'slider';
SPINBOX: 		'spinbox';
TEXT: 			'text';
RADIO:			'radiobutton';
DROPDOWN:		'dropdown';
CHECKBOX:		'checkbox';
WIDTH: 			'width';
HEIGHT: 		'height';
FONTSIZE: 		'fontSize';
FONT: 			'font';
COLOR:			'color';

//Font keywords
ARIAL: 			'arial';


//Symbols
COLON:         ':';
COMMA: 			',';
LEFT_PAREN:  	'(';
RIGHT_PAREN:   	')';
LEFT_BRACE:    '{';
RIGHT_BRACE:   '}';
LEFT_BRACKET:    '[';
RIGHT_BRACKET:   ']';

NewLine: '\n''\t';

IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

WhiteSpace: (' ' | '\t' | '\n' | '\r') -> skip;

MultiComment: '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;

RgbValue: '#'[0-9]*;


