grammar QLSGrammar;

@lexer::header  { package uva.sc.qls.parser; }
@parser::header { package uva.sc.qls.parser; }

stylesheet
 : 'stylesheet' ID  pages+=page+ 
 ;
 
page
 : 'page' ID '{' sections+=section+ defaultStyle? '}' 
 ;
 
section
 : 'section' STRING sectionBody;
 
sectionBody
 : questions+=question
 | '{' questions+=question+ sections+=section* defaultStyle? '}'
 ;
 
question
 : 'question' ID widget?
 ;
 
widget
 : 'widget' widgetType ('(' STRING ',' STRING ')')?
 ;
 
defaultStyle
 : 'default' type '{' styleProperties+=styleProperty+  widget '}'
 | 'default' type widget
 ;
 
styleProperty
 : 'width:' NUMBER			#width
 | 'font:' font				#fontName
 | 'fontsize:' NUMBER		#fontsize
 | 'color:' COLORENCODE		#color
 ;

type
 : 'boolean'				#boolean
 | 'number'					#number
 | 'string'					#string
 ;
 
widgetType
 : 'checkbox'				#checkbox
 | 'spinbox'				#spinbox
 | 'radio'					#radio
 ;
 
font
 : '"Arial"'				#arial
 | '"Times New Roman"'		#timesNewRoman
 | '"Bazooka"'				#bazooka
 | '"Book Antiqua"'			#bookAntiqua
 | '"Courier"'				#courier
 | '"Dialog"'				#dialog
 ; 

BOOLEAN: TRUE | FALSE;
TRUE : 'true' | 'TRUE' | 'True';
FALSE : 'false' | 'FALSE' | 'False' ;

ID
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

COLORENCODE 
 : '#'[A-F0-9][A-F0-9][A-F0-9][A-F0-9][A-F0-9][A-F0-9]
 ;

NUMBER
 : [0-9]+ '.' [0-9]* 
 | '.' [0-9]+
 | [0-9]+
 ;

STRING
 : '"' (~["\r\n] | '""')* '"'
 ;

COMMENT
 : '//' .*? '\n' -> skip
 ;

WS 
 : [ \t\r\n]+ -> skip 
 ;
