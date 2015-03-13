grammar QLS;

/*
 *   Parser Rules
 */

stylesheet : 'stylesheet' ID page*                             # StyleSheet
	       ;

page       : 'page' STRING '{' (section|default_styles)* '}'
           ;
section    : 'section' STRING '{' (question_styles|default_styles)* '}'
           ;

question_styles : 'question' ID '{' style_attr* '}'            # QuestionStyles
                ;
default_styles : 'default' TYPE '{' style_attr+ '}'            # DefaultStyles
               ;

style_attr : 'width:'	INT										# Width
           | 'widget:'	WIDGET                                  # Widget
           | 'font:'	STRING                                  # Font
           | 'fontsize:'INT										# FontSize
           | 'color:'	HEXACOLOR                               # Color
		   ;

/*
 *   Lexer Rules
 */

ID        : LETTER (LETTER | DIGIT)* ;
HEXACOLOR : '#' DIGIT DIGIT DIGIT DIGIT DIGIT DIGIT ;
INT       : '-'? DIGIT+ ;             
STRING    : '"' (ESC|.)*? '"' ;       
WIDGET    : 'calendar' 
		  | 'checkbox' 
		  | 'dropdownbox' '(' STRING ',' STRING ')' 
		  | 'radiobuttons' '(' STRING ','  STRING ')'
		  | 'spinbox' 
		  |	'textbox'
		  ;
TYPE      : 'int' | 'string' | 'bool' | 'date';

DIGIT     : [0-9] ;
LETTER    : [a-zA-Z] ;
ESC       : '\\"' | '\\\\' ;
