grammar QL;

form : 'form' Identifier '{' formElement* '}' ;
formElement : question | conditionalBlock ; 

question : Identifier Type questionString possibleAnswers?;
questionString : Text ;
possibleAnswers : '[' answer+=Text (',' answer+=Text)* ']' ;

conditionalBlock : ifThenBlock elseIfThenBlock* elseThenBlock? 'endif';
ifThenBlock : 'if' '(' expression ')' '{' formElement* '}' ;
elseIfThenBlock : 'elseif' '(' expression ')' '{' formElement* '}' ;
elseThenBlock : 'else' '{' formElement* '}' ;

expression : UnaryOperator expression					# UnaryExpression
			| expression MultiplyOperator expression	# MultiplyExpression
			| expression AdditionOperator expression	# AdditionExpression
			| expression ComparisonOperator expression	# ComparisonExpression
			| expression EqualityOperator expression	# EqualityExpression
			| expression AndOperator expression			# AndExpression
			| expression OrOperator expression			# OrExpression
			| '(' expression ')'						# ParenthesesExpression
			| Boolean									# BooleanLiteral
			| Identifier								# IdentifierLiteral
			| Text										# TextLiteral
			| Number									# NumberLiteral
			;

UnaryOperator : '!' | '+' '-';
MultiplyOperator : '*' | '/' ;
AdditionOperator : '+' | '-' ;
ComparisonOperator : '>' | '>=' | '<' | '<=' ;
EqualityOperator : '==' | '!=' ;
AndOperator : '&&' ;
OrOperator : '||' ;

Type : 'boolean' | 'number' | 'text' ;

Boolean : 'yes' | 'no';
Text : '"' .*? '"' ;
Identifier : Letter (Letter | Digit)* ;
Number : Digit+ ;

Whitespace : [ \t\r\n]+ -> skip ;
Comment : '#' ~[\r\n]* '\r'? '\n' -> skip ;

fragment Digit : [0-9] ;
fragment Letter : [a-zA-Z] ;
