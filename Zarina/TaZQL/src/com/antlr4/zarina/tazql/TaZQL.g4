grammar TaZQL;

options {
	language = Java;
}

questionnaire	: form EOF;

form		 	: 'FORM' ID '{' question+ '} END';									

question		: ID TEXT TYPE	 			 											# simpleQuestion
				| ID TEXT TYPE '(' expression ')'										# calcQuestion
				| 'if' '(' expression ')' '{' question+ '}'								# ifStatement
				| 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'	# ifelseStatement
				;

expression		: '!' expression														# not															
				| expression ('*'| '/') expression										# multDiv
				| expression ('+'| '-') expression										# addSub
				| expression ('>'|'>='|'<'|'<=') expression								# equation
				| expression ('=='|'!=') expression										# eqNot
				| expression ('&&') expression											# and
				| expression ('||') expression											# or
				| BOOLEAN 																# boolean
				| ID 																	# id
				| TEXT 																	# text
				| NUMBER																# number
				| '(' expression ')'													# prio		
				;
 
TYPE  			: 'choice' | 'digits' | 'text';				  
BOOLEAN			: 'true' | 'false';  
	  
	  
NUMBER			: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT			:'"'.*? '"';	
ID 				:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  			: (' ' | '\t' | '\n' | '\r')+ -> skip;

NEWLINE 		:'\r'?'\n';
COMMENTS		: '//' NEWLINE -> skip;
