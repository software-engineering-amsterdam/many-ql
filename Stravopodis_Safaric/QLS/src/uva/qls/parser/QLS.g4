
grammar QLS;


prog		: stylesheet EOF;

stylesheet	: 'stylesheet' Identifier pgs+=page*;

page 		: 'page' Identifier '{' stms+=statement* '}';	// Say that a page has to have sections or not?

statement 	: section		# CtxSection
			| subsection	# CtxSubsection
			| question 		# CtxQuestion
			| defaultValue  # CtxDefaultValue
			| component 	# CtxComponenet
			| style			# CtxStyle
			;

section		: 'section' STRING '{' stms+=statement* '}';

subsection 	: 'subsection ' STRING '{' question '}';

question	: 'question' Identifier cmp=component?;

defaultValue: 'default' primitiveType ( component | ('{' stms+=statement* '}')) ;

component	: Widget Textbox										
			| Widget Spinbox									
			| Widget Slider '(' STRING ',' STRING ')'			
			| Widget Dropdown '(' STRING ',' STRING ')'			
			| Widget Radio '(' STRING ',' STRING ')'			
			| Widget Checkbox '(' STRING ')'										
			;

style		: Width ':' Integer			# CtxWidth
			| Height ':' Integer		# CtxHeight
			| Font ':' STRING			# CtxFont
			| Fontsize ':' Integer		# CtxFontsize
			| Color ':' HASH Integer	# CtxColor
			;


literal		: BooleanLiteral # CtxBooleanLiteral
			| Integer		 # CtxInteger
			| Decimal		 # CtxDecimal				
			;

BooleanLiteral 	: 'true'
				| 'false'
				;

primitiveType	: 'boolean'
				| 'decimal'
				| 'string'
				| 'int'
				;

Width		: 'width';
Height		: 'height';
Font		: 'font';
Fontsize	: 'fontsize';
Color		: 'color';
Widget 		: 'widget';
Textbox 	: 'textbox';
Spinbox		: 'spinbox';
Slider		: 'slider';
Dropdown	: 'dropdown';
Radio		: 'radio';
Checkbox	: 'checkbox';

Identifier	: ID_LETTER (ID_LETTER | DIGIT)* ;

Integer		: (DIGIT | ('(-'DIGIT')')) ;

Decimal		: ('(''-')? DIGIT+ '.' DIGIT* ')'? ;

WS			: (' ' | NEWLINE | TAB) -> skip;

/* It gets form, if etc as an identifier and not as keywords */


ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

DIGIT		: '0' | [1-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

HASH		: '#';

NEWLINE 	: '\n';
TAB			: '\t';

LP			: '(' ;
RP			: ')' ;
LC			: '{' ;
RC			: '}' ;
