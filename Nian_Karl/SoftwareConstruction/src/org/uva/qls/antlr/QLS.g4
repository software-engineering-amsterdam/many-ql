grammar QLS;

sheet: STYLE Identifier page*;

page: PAGE Identifier LEFT_BRACE section* style* RIGHT_BRACE;

section: SECTION StringLiteral LEFT_BRACE question* style* RIGHT_BRACE ;

question: QUESTION Identifier widget
		|QUESTION Identifier;
		

style:DEFAULT type styleProp
	|DEFAULT type LEFT_BRACE styleProp* RIGHT_BRACE
	; 

styleProp : WIDGET COLON widgetProp = widget #widgetStyle
	| WIDTH COLON widthProp = IntegerLiteral #widthStyle
	| HEIGHT COLON heightProp = IntegerLiteral #heightStyle
	| FONTSIZE COLON fontSizeProp = IntegerLiteral #fontSizeStyle
	| FONT COLON fontProp = font #fontStyle
	| BACKGROUNDCOLOR COLON colorProp = rgb #backgroundColorStyle
	;
	
rgb : 'rgb' LEFT_PAREN red=IntegerLiteral COMMA green=IntegerLiteral COMMA blue=IntegerLiteral RIGHT_PAREN;

type: 	INT #intType
	| STR #strType
	| BOOL #boolType
	;


font: ARIAL;

widget: TEXTBOX #textbox
	| CHECKBOX #checkbox
	| SPINBOX LEFT_BRACKET IntegerLiteral (COMMA IntegerLiteral)+ RIGHT_BRACKET #spinbox
	| SLIDER LEFT_PAREN min = IntegerLiteral COMMA max = IntegerLiteral RIGHT_PAREN #slider
	| DROPDOWN LEFT_PAREN firstLabel = StringLiteral COMMA secondLabel = StringLiteral RIGHT_PAREN #dropdown
	| RADIO LEFT_PAREN firstLabel = StringLiteral COMMA secondLabel = StringLiteral RIGHT_PAREN #radio
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
BACKGROUNDCOLOR:			'background-color';

//Font keywords
ARIAL: 			'Arial';


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





