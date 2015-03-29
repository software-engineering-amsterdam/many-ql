grammar QLS;

/*
 *   Parser Rules
 */

stylesheet : 'stylesheet' ID '{' page* '}'                     # StyleSheet
	       ;

page       : 'page' ID '{' (section|default_style)* '}'
           ;
section    : 'section' STRING '{' (question_ref|default_style)* '}'
           ;

question_ref  : 'question' ID ('{' style_attr* '}')?              # QuestionReference
              ;
default_style : 'default' TYPE '{' style_attr+ '}'                # DefaultStyle
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

INT       : '-'? DIGIT+ ;             
STRING    : '"' (ESC|.)*? '"' ;       
HEXACOLOR : '#' HEXADEC HEXADEC HEXADEC HEXADEC HEXADEC HEXADEC ;

TYPE      : 'int' | 'string' | 'bool' | 'date' ;
ID        : LETTER (LETTER | DIGIT)* ;

HEXADEC   : [0-9A-F] ;
DIGIT     : [0-9] ;
LETTER    : [a-zA-Z] ;
ESC       : '\\"' | '\\\\' ;
