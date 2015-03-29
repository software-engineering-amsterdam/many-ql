grammar QLS;

/*
 *   Parser Rules
 */

stylesheet : 'stylesheet' ID '{' page* '}'                     # StyleSheet
	       ;

page       : 'page' ID '{' (section|default_styles)* '}'
           ;
section    : 'section' STRING '{' (question_ref|default_styles)* '}'
           ;

question_ref   : 'question' ID '{' style_attr* '}'             # QuestionReference
               ;
default_styles : 'default' TYPE '{' style_attr+ '}'            # DefaultStyles
               ;

style_attr : 'widget:'	widget_attr                               # Widget
           | 'font:'	STRING                                    # Font
           | 'fontsize:'INT                                       # FontSize
           | 'color:'	HEXACOLOR                                 # Color
		   ;

widget_attr : 'calendar'                                          # Calendar
	  	    | 'checkbox'                                          # CheckBox
		    | 'dropdownbox' '(' STRING ',' STRING ')'             # DropDown
		    | 'radiobuttons' '(' STRING ','  STRING ')'           # RadioButtons
		    | 'spinbox'                                           # SpinBox
		    | 'textbox'                                           # TextBox
		    ;


/*
 *   Lexer Rules
 */

ID        : LETTER (LETTER | DIGIT)* ;
HEXACOLOR : '#' HEXADEC HEXADEC HEXADEC HEXADEC HEXADEC HEXADEC ;
INT       : '-'? DIGIT+ ;             
STRING    : '"' (ESC|.)*? '"' ;       
TYPE      : 'int' | 'string' | 'bool' | 'date';

HEXADEC   : [0-9A-F] ;
DIGIT     : [0-9] ;
LETTER    : [a-zA-Z] ;
ESC       : '\\"' | '\\\\' ;
