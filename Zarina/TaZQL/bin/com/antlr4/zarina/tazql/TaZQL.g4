grammar TaZQL;

options {
	language = Java;
}

form			: 'FORM' ID '{' question+ '} END' EOF;

question		: ID TEXT type	 			 											# simpleQuestion
				| ID TEXT type '(' expression ')'										# computationQuestion
				| 'if' '(' expression ')' '{' question+ '}'								# ifStatement
				| 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'	# ifelseStatement
				;

expression		: op=('!'|'+'|'-') expression											# unaryExpression															
				| expression op=('*'| '/') expression									# multDivExpression
				| expression op=('+'| '-') expression									# addSubExpression
				| expression op=('>'|'>='|'<'|'<=') expression							# comparissionExpression
				| expression op=('=='|'!=') expression									# equationExpression
				| expression '&&' expression											# andExpression
				| expression '||' expression											# orExpression
				| BOOLEAN 																# booleanExpression
				| ID 																	# id
				| TEXT 																	# text
				| NUMBER																# number
				| '(' expression ')'													# bracketsExpression		
				;
 
type  			: 'choice' 																# booleanType
				| 'digits' 																# integerType
				| 'text'																# stringType
				;
								  
BOOLEAN			: 'true' | 'false';  
	  
	  
NUMBER			: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT			:'"'(ESC | .)*? '"';	
ID 				:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  			: (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE 		:'\r'?'\n';
COMMENTS		: '//' NEWLINE -> skip;
fragment 
ESC				: '\\"' | '\\\\'; 
