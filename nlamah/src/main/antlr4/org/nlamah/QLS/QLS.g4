grammar QLS;

stylesheet: 'stylesheet' Identifier  '{' (page | defaultBlock)* '}' ;

page: 'page' Identifier '{' (section | defaultBlock)* '}' ;

section : 'section' Text '{' (stylesheetBlock | defaultBlock)* '}' ;

stylesheetBlock: section | styledQuestion;

styledQuestion : 'question' Identifier widgetDeclaration? ;

defaultBlock : 'default' QuestionType ('{' styleDeclaration* '}' | styleDeclaration);

styleDeclaration : widthDeclaration	
				| fontDeclaration
				| fontSizeDeclaration
				| colorDeclaration
				| widgetDeclaration
				;

widthDeclaration : 'width:' Number ;
fontDeclaration : 'font:' Text ;
fontSizeDeclaration : 'fontsize:' Number ;
colorDeclaration : 'color:' HexNumber;

widgetDeclaration : 'widget' widgetType ;
widgetType : 'checkbox' 									#checkBoxType
			| 'spinbox' 									#spinBoxType
			| 'radio('answer+=Text (',' answer+=Text)* ')'	#radioButtonType
			;

QuestionType : 'boolean' | 'number' | 'text' ;
Text : '"' .*? '"' ;
Identifier : Letter (Letter | Digit)* ;
Number : (Digit)+ ;
HexNumber : '#'HexDigit HexDigit HexDigit | '#'HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit ;

Whitespace : [ \t\r\n]+ -> skip ;
Comment : '//' ~[\r\n]* '\r'? '\n' -> skip ;

fragment Digit : [0-9] ;
fragment Letter : [a-zA-Z] ;
//HexDigit : '0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'|'a'|'A'|'b'|'B'|'c'|'C'|'d'|'D'|'e'|'E'|'f'|'F' ;
fragment HexDigit :[0-9] | [a-fA-F] ;