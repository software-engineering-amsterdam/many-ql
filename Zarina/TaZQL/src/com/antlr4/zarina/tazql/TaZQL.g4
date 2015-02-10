grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}

parse      		: formSection EOF;

formSection 	: 'FORM' ID '{' question+ '} END';

question		: simpleQuestion 														# basicQuestion
				| computedQuestion														# calcQuestion
				| 'if' '(' expression ')' '{' question+ '}'								# ifStatement
				| 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'	# ifelseStatement
				;

expression		: ID 																	# id
				| BOOLEAN 																# boolean
				| TEXT 																	# text
				| NUMBER																# number
				| expression ('*'| '/') expression										# multDiv
				| expression ('+'| '-') expression										# addSub
				| expression ('=='|'!=') expression										# eqNot
				| expression ('&&') expression											# and
				| expression ('||') expression											# or
				| expression ('>'|'>='|'<'|'<=') expression								# equation
				| '(' expression ')'													# prio		
				;
				
simpleQuestion	: ID TEXT TYPE;   	 
				 									
computedQuestion: ID TEXT TYPE '(' expression ')';
 
TYPE  			: 'choice' | 'digit' | 'text';				  
BOOLEAN			: 'true' | 'false';  
	  
	  
NUMBER			: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT			:'['(ID |SPECIAL|NUMBER|WS)*']';	
ID 				:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  			: (' ' | '\t' | '\n' | '\r')+ -> skip;
SPECIAL			: [:?!,\.;];
NEWLINE 		:'\r'?'\n';
COMMENTS		: '//' NEWLINE -> skip;
