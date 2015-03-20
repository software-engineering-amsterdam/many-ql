
grammar QLS;

@header{
	package uva.qls.parser;
}

prog		: stylesheet EOF;

stylesheet	: 'stylesheet' id = Identifier pgs+=page*;

page 		: 'page' id = Identifier '{' stms+=statement* '}';	// Say that a page has to have sections or not?

statement 	: section		# CtxSection
			| subsection	# CtxSubsection
			| question 		# CtxQuestion
			| defaultValue  # CtxDefaultValue
			| component 	# CtxComponent
			| style			# CtxStyle
			;

section		: 'section' STRING '{' stms+=statement* '}';

subsection 	: 'subsection ' STRING '{' quest = question '}';

question	: 'question' id = Identifier cmp=component?;

defaultValue: 'default' primitiveType cmp = component			# CtxDefaultComponent		
			| 'default' primitiveType '{' stms+=style* '}'		# CtxDefaultStatement
			;		

component	: Widget Textbox 										('{' stls+=style* '}')?							# CtxTextbox										
			| Widget Spinbox 										('{' stls+=style* '}')?							# CtxSpinbox
			| Widget Slider '(' v1 = STRING ',' v2 =STRING ')'		('{' stls+=style* '}')?							# CtxSlider
			| Widget Dropdown '(' v1 = STRING ',' v2 = STRING ')'	('{' stls+=style* '}')? 						# CtxDropdown		
			| Widget Radio '(' v1 = STRING ',' v2 = STRING ')'		('{' stls+=style* '}')?							# CtxRadio	
			| Widget Checkbox '(' STRING ')'						('{' stls+=style* '}')?							# CtxCheckbox	
			;

style		: Width ':' v = Integer			# CtxWidth
			| Height ':' v = Integer		# CtxHeight
			| Font ':' v = STRING			# CtxFont
			| Fontsize ':' v = Integer		# CtxFontsize
			| Color ':' HASH v = Integer	# CtxColor
			;


literal		: BooleanLiteral # CtxBooleanLiteral
			| Integer		 # CtxInteger
			| Money			 # CtxMoney				
			;

BooleanLiteral 	: 'true'
				| 'false'
				;

primitiveType	: 'boolean'		# CtxPrimitiveBoolean
				| 'money'		# CtxPrimitiveMoney
				| 'string'		# CtxPrimitiveString
				| 'integer'		# CtxPrimitiveInteger
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

Money		: Integer ;

WS			: (' ' | NEWLINE | TAB) -> skip;

/* It gets form, if etc as an identifier and not as keywords */


ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

DIGIT		: '0' | [0-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

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
