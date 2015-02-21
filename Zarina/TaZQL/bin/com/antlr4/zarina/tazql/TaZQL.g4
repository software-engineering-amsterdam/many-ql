grammar TaZQL;

options {
	language = Java;
}

form			: 'FORM' ID '{' question+ '} END' EOF;

//form		 	: 'FORM' ID '{' question+ '} END';									

question		: ID TEXT type	 			 											# simpleQuestion
				| ID TEXT type '(' expression ')'										# computationQuestion
				| 'if' '(' expression ')' '{' question+ '}'								# ifStatement
				| 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'	# ifelseStatement
				;

expression		: op='!' expression														# notExpression															
				| expression op=('*'| '/') expression										# multDivExpression
				| expression op=('+'| '-') expression										# addSubExpression
				| expression op=('>'|'>='|'<'|'<=') expression								# equationExpression
				| expression op=('=='|'!=') expression										# eqNotExpression
				| expression ('&&') expression											# andExpression
				| expression ('||') expression											# orExpression
				| BOOLEAN 																# booleanExpression
				| ID 																	# id
				| TEXT 																	# text
				| NUMBER																# number
				| '(' expression ')'													# nestedExpression		
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
