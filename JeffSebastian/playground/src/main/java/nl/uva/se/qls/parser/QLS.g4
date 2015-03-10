grammar QLS;

options {
	language = Java;
}

@lexer::header {
package nl.uva.se.qls.parser;
}

@parser::header {
package nl.uva.se.qls.parser;
}
	
// -------- PARSER RULES --------

stylesheet
	: STYLESHEET Identifier (page)+
	;

page
	: PAGE Identifier '{' (section)+ '}'
	;

section
	: SECTION String '{' (question | section | defaultBlock)+ '}'
	;

question	
	: QUESTION Identifier (widget)+
	;

widget
	: WIDGET widgetType 
	;
	
defaultBlock
	: DEFAULT Type widget
	| DEFAULT Type '{' (styleRule)+ widget '}'
	;
	
styleRule
	: WIDTH ':' Integer
	| FONT ':' String
	| FONTSIZE ':' Integer
	| COLOR ':' '#' Integer
	;

widgetType
	: Checkbox
	| Spinbox
	| radio
	;

radio
	: Radio '(' String (',' String)? ')'
	;

// -------- LEXER RULES --------

Type
	: 'boolean'
	| 'decimal'
	;
	
// FRAGMENTS
fragment DIGIT				: [0-9];
fragment LETTER_AND_NUMBER  : [a-zA-Z_][a-zA-Z_0-9]*;

// KEYWORD TOKENS
STYLESHEET 	: 'stylesheet'|'Stylesheet'|'STYLESHEET';
PAGE		: 'page'|'Page'|'PAGE';
SECTION		: 'section'|'Section'|'SECTION';
QUESTION	: 'question'|'Question'|'QUESTION';
WIDGET		: 'widget'|'Widget'|'WIDGET';
DEFAULT		: 'default'|'Default'|'DEFAULT';

// WIDGETS
Checkbox	: 'checkbox';
Spinbox		: 'spinbox';
Radio		: 'radio';

// STYLERULES
WIDTH		: 'width';
FONT		: 'font'; 
FONTSIZE	: 'fontsize';
COLOR		: 'color';

// LITERALS
Integer				: DIGIT*;
Decimal				: DIGIT* '.' DIGIT*;
Boolean				: 'true' | 'false';
String				: '"' .* '"';
Identifier			: LETTER_AND_NUMBER*;

// OVERHEAD
WS:(' ' | '\t' | '\n' | '\r') -> channel(HIDDEN);
MC: '/*' .*? '*/' -> channel(HIDDEN);
SC: '//' .*? '\n' -> channel(HIDDEN);