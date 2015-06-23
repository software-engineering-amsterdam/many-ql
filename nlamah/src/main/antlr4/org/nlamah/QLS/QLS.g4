grammar QLS;

stylesheet: 'stylesheet' Identifier  '{' page* defaultBlock* '}' ;

page: 'page' Identifier '{' section* defaultBlock* '}' ;

section : 'section' Text '{' stylesheetBlock* defaultBlock* '}' ;

stylesheetBlock: section | styledQuestion ;

styledQuestion : 'question' Identifier ('{' styleDeclaration* '}' | styleDeclaration)? ;

defaultBlock : 'default' QuestionType? ('{' styleDeclaration* '}' | styleDeclaration) ;

styleDeclaration : 'width:' Number		#widthDeclaration
				| 'font:' Text			#fontDeclaration
				| 'fontsize:' Number	#fontSizeDeclaration
				| 'color:' HexNumber	#colorDeclaration
				| 'widget' widgetStyle	#widgetDeclaration
				;

widgetStyle : 'checkbox' 																					#checkBox
			| 'spinbox' 																					#spinBox
			| 'radio('answer+=Text ':' value+= BooleanValue ',' answer+=Text ':' value+= BooleanValue ')' 	#radioButtonBoolean
			| 'radio('answer+=Text (',' answer+=Text)* ')'													#radioButtonText
			| 'radio('answer+=Number (',' answer+=Number)* ')' 												#radioButtonNumber
			| 'textfield'																					#textField
			| 'numberfield'																					#numberField
			;

QuestionType : 'boolean' | 'number' | 'text' ;
BooleanValue : 'yes' | 'no' ;
Text : '"' .*? '"' ;
Identifier : Letter (Letter | Digit)* ;
Number : (Digit)+ ;
HexNumber : '#'HexDigit HexDigit HexDigit | '#'HexDigit HexDigit HexDigit HexDigit HexDigit HexDigit ;

Whitespace : [ \t\r\n]+ -> skip ;
Comment : '//' ~[\r\n]* '\r'? '\n' -> skip ;

fragment Digit : [0-9] ;
fragment Letter : [a-zA-Z] ;
fragment HexDigit :[0-9] | [a-fA-F] ;