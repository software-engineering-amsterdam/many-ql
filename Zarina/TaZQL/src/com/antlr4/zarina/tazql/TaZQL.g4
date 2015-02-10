grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}

parse      		: formSection EOF;

formSection 	: 'FORM' ID '{' question+ '} END';

question		: simpleQuestion 
				| computedQuestion							
				| 'if' '(' expression ')' '{' question+ '}'
				| 'if' '(' expression ')' '{' question+ '}' 'else' '{' question+ '}'
				;

expression		: ID | type | TEXT | NUMBER
				| expression ('*'| '/') expression
				| expression ('+'| '-') expression
				| expression ('=='|'!=') expression	
				| expression ('&&') expression
				| expression ('||') expression
				| expression ('>'|'>='|'<'|'<=') expression
				| '(' expression ')';							

simpleQuestion	: ID TEXT type;   	 
				 									
computedQuestion: ID TEXT type '(' expression ')';
 
type  			: 'boolean' | 'integer' | 'double' | 'String';    
	  
NUMBER		: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT		:'['(ID |SPECIAL|NUMBER|WS)*']';	
ID 			:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  		: (' ' | '\t' | '\n' | '\r')+ -> skip;
SPECIAL		: [:?!,\.;];
NEWLINE 	:'\r'?'\n';
COMMENTS	: '//' NEWLINE -> skip;
