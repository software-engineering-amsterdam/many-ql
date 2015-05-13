grammar QLS;

stylesheet: 'stylesheet' Identifier  '{' page* defaultBlock* '}' ;

page: 'page' Identifier '{' section* defaultBlock* '}' ;

section : 'section' Text '{' stylesheetBlock* defaultBlock* '}' ;

stylesheetBlock: section | styledQuestion;

styledQuestion : 'question' Identifier ('{' styleDeclaration* '}' | styleDeclaration)? ;

defaultBlock : 'default' QuestionType? ('{' styleDeclaration* '}' | styleDeclaration) ;

styleDeclaration : 'width:' Number		#widthDeclaration
				| 'font:' Text			#fontDeclaration
				| 'fontsize:' Number	#fontSizeDeclaration
				| 'color:' HexNumber	#colorDeclaration
				| 'widget' widgetType	#widgetDeclaration
				;

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
fragment HexDigit :[0-9] | [a-fA-F] ;