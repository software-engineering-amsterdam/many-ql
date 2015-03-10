grammar QLS;

sheet: STYLE Identifier page*;

page: PAGE Identifier LEFT_BRACE section* style* RIGHT_BRACE;


section: SECTION StringLiteral LEFT_BRACE question* style* RIGHT_BRACE ;

question: QUESTION Identifier widget
		|QUESTION Identifier;
		

style:DEFAULT type styling
	|DEFAULT type LEFT_BRACE styling* RIGHT_BRACE
	; 

styling: WIDGET COLON widget
	| WIDTH COLON IntegerLiteral
	| HEIGHT COLON IntegerLiteral
	| FONTSIZE COLON IntegerLiteral
	| FONT COLON font
	| COLOR COLON rgb
	;
	
rgb : 'rgb' LEFT_PAREN red=IntegerLiteral COMMA green=IntegerLiteral COMMA blue=IntegerLiteral RIGHT_PAREN;

type: INT
	| STR
	| BOOL
	;


font: ARIAL;

widget: TEXTBOX #textbox
	| CHECKBOX #checkbox
	| SPINBOX LEFT_BRACKET IntegerLiteral (COMMA IntegerLiteral)+ RIGHT_BRACKET #spinbox
	| SLIDER LEFT_PAREN IntegerLiteral COMMA IntegerLiteral RIGHT_PAREN #slider
	| DROPDOWN LEFT_PAREN trueLabel = StringLiteral COMMA falseLabel = StringLiteral RIGHT_PAREN #dropdown
	| RADIO LEFT_PAREN trueLabel = StringLiteral COMMA falseLabel = StringLiteral RIGHT_PAREN #radio
	;

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
TEXTBOX:		'textbox';
RADIO:			'radio';
DROPDOWN:		'dropdown';
CHECKBOX:		'checkbox';
WIDTH: 			'width';
HEIGHT: 		'height';
FONTSIZE: 		'fontsize';
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





