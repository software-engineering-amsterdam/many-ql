grammar QLS;

stylesheet: 'stylesheet' Identifier  page* ;
page: 'page' Identifier ('{' section '}')*;
section : Text sectionContent ;
sectionContent : section | question widgetSection? | defaultSection ;

question : 'question' Identifier ;
widgetSection : 'widget' widgetType ;
widgetType : 'checkbox' | 'spinbox' | 'radio('answer+=Text (',' answer+=Text)* ')';

defaultSection : 'default' QuestionType '{' (defaultDeclaration)+ '}';
defaultDeclaration : widthDeclaration | fontDeclaration | fontSizeDeclaration | colorDeclaration | widgetSection ;

widthDeclaration : 'width:' Number ;
fontDeclaration : 'font:"' Identifier '"' ;
fontSizeDeclaration : 'fontsize:' Number ;
colorDeclaration : 'color:' HexNumber;


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