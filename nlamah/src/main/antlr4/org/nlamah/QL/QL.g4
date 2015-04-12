grammar QL;

form : 'form' ID '{' formElement* '}' ;
formElement : question | conditionalBlock ; 

question : ID TYPE questionString possibleAnswers?;
questionString : STRING ;
possibleAnswers : '[' answer+=STRING (',' answer+=STRING)* ']' ;
// if ( s ) { t } endif
// if ( s ) { t } else { e } endif
// if ( s ) { t } elsif ( s ) { t } endif
// if ( s ) { t } elsif ( s ) { t } else { e } endif
// ifthen + elif* + else* + endif

conditionalBlock : ifThenBlock elseIfThenBlock* elseThenBlock? 'endif';
ifThenBlock : 'if' '(' expression ')' '{' formElement* '}' ;
elseIfThenBlock : 'elseif' '(' expression ')' '{' formElement* '}' ;
elseThenBlock : 'else' '{' formElement* '}' ;

expression		:  '(' expression ')' 							# parenthesesExpression
				| op=('!'|'+'|'-') expression 					# unaryExpression
				| expression op=('*'| '/') expression 			# multiplyExpression
				| expression op=('+'| '-') expression 			# additionExpression
				| expression op=('>'|'>='|'<'|'<=') expression 	# comparisonExpression
				| expression op=('=='|'!=') expression 			# equationExpression
				| expression '&&' expression 					# andExpression
				| expression '||' expression 					# orExpression
				| BOOLEAN 										# booleanExpression
				| ID 											# idExpression
				| STRING 										# stringExpression
				| NUMBER 										# numberExpression
				;

TYPE : 'boolean' | 'int' ;
BOOLEAN : 'yes' | 'no';
STRING : '"' .*? '"' ;
ID : LETTER (LETTER | DIGIT)* ;
NUMBER : DIGIT+ ;

WS : [ \t\r\n]+ -> skip ;
COMMENT : '#' ~[\r\n]* '\r'? '\n' -> skip ;

fragment DIGIT : [0-9] ;
fragment LETTER : [a-zA-Z] ;
