grammar QL;

form : 'form' Identifier '{' formElement* '}' ;
formElement : question | conditionalBlock ; 

question : Identifier type=('boolean' | 'number' | 'text') Text '=' expression		#ComputedQuestion
		| Identifier 'boolean' Text 												#BooleanQuestion	
		| Identifier 'number' Text													#NumberQuestion
		| Identifier 'text' Text													#TextQuestion
		;

conditionalBlock : ifThenBlock elseIfThenBlock* elseThenBlock? 'endif';
ifThenBlock : 'if' '(' expression ')' '{' formElement* '}' ;
elseIfThenBlock : 'elseif' '(' expression ')' '{' formElement* '}' ;
elseThenBlock : 'else' '{' formElement* '}' ;

expression : operator=('-' |'+' | '!') expression		# UnaryExpression
			| '(' expression ')'						# ParenthesesExpression
			| expression MultiplyOperator expression	# MultiplyExpression
			| expression op=('+' | '-') expression		# AdditionExpression
			| expression ComparisonOperator expression	# ComparisonExpression
			| expression EqualityOperator expression	# EqualityExpression
			| expression AndOperator expression			# AndExpression
			| expression OrOperator expression			# OrExpression
			| Boolean									# BooleanLiteral
			| Identifier								# IdentifierLiteral
			| Text										# TextLiteral
			| Number									# NumberLiteral
			;

MultiplyOperator : '*' | '/' ;
ComparisonOperator : '>' | '>=' | '<' | '<=' ;
EqualityOperator : '==' | '!=' ;
AndOperator : '&&' ;
OrOperator : '||' ;

Boolean : 'yes' | 'no';
Text : '"' .*? '"' ;
Identifier : Letter (Letter | Digit)* ;
Number : (Digit)+ ;

Whitespace : [ \t\r\n]+ -> skip ;
Comment : '//' ~[\r\n]* '\r'? '\n' -> skip ;

fragment Digit : [0-9] ;
fragment Letter : [a-zA-Z] ;
