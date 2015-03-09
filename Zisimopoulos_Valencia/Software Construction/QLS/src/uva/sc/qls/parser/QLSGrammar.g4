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
 : ID ':' atom
 ;

type
 : 'boolean' 
 | 'number'
 | 'string'
 ;
 
widgetType
 : 'checkbox'
 | 'spinbox'
 | 'radio'
 ;
 
atom
 : NUMBER		   #number
 | BOOLEAN 		   #boolean
 | ID              #id
 | STRING          #string
 | COLORENCODE     #colorencode
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
