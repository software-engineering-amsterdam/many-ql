grammar QLS;

sheet: STYLE Identifier page*;

page: PAGE Identifier pageBlock;

pageBlock: LEFT_PAREN section* style RIGHT_PAREN;

section: SECTION StringLiteral LEFT_PAREN question* RIGHT_PAREN ;

question:QUESTION Identifier style;

style:DEFAULT type styling
	|DEFAULT type LEFT_PAREN styling* RIGHT_PAREN
	; 

styling: WIDGET COLON widget
	| WIDTH COLON IntegerLiteral
	| HEIGHT COLON IntegerLiteral
	| FONTSIZE COLON IntegerLiteral
	| FONT COLON font
	| COLOR COLON RgbValue
	;

type: INT
	| STR
	| BOOL
	;


font: ARIAL;

widget: TEXT
	| CHECKBOX
	| SPINBOX intWidgetParam
	| SLIDER intWidgetParam
	| DROPDOWN boolWidgetParam
	| RADIO boolWidgetParam
	;

intWidgetParam: LEFT_BRACKET IntegerLiteral (COMMA IntegerLiteral)+ RIGHT_BRACKET;
boolWidgetParam: LEFT_PAREN trueLabel = StringLiteral COMMA falseLabel = StringLiteral RIGHT_PAREN;

/* LEXER RULES */

//Keywords
STYLE:		 	'style';
PAGE: 			'page';
SECTION:		'section';
QUESTION: 		'question';
DEFAULT: 		'default';

//types
INT:           'Int';
STR:           'Str';
BOOL:          'Bool';

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

IntegerLiteral: [1-9][0-9]*;

BooleanLiteral: 'true' | 'false';

StringLiteral: '"' (~[\r\n"] | '""')* '"';

WhiteSpace: (' ' | '\t' | '\n' | '\r') -> skip;

MultiComment: '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Identifier: [a-zA-Z][a-zA-Z0-9_]*;

RgbValue: '#'[0-9]*;


