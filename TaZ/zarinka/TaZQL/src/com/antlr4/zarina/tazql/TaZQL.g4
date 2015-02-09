grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}

parse      		: form+ EOF;
form			: formSection+;

formSection 	: 'FORM' ID block+;

block			: '<' questionBlock+ '>';

questionBlock	: question
				| block  												// probably can be removed 
				| 'if' '(' statement  ')' question+  					//if statement
				| 'if' '(' statement ')' question+ ('else if' '(' statement ')' question+ )* 'else' '(' question+ ')'; 		//if -if-else- else';
		

statement		: ID | question | questionId | statement '==' statement;		// should be changed, expanded, operators etc

question	 	: questionId NUMBER TEXT type;
		
type  			: 'boolean' | 'integer' | 'double' | 'String' | choise;   
choise 			: '[' question ']'+ | 'true' | 'false' ; 
	  

questionId : ID;
//{System.out.println("questionId from a grammar: " +$ID.text);} ;


NUMBER		: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT		:'['(ID |SPECIAL|NUMBER|WS)*']';	
ID 			:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  		: (' ' | '\t' | '\n' | '\r')+ -> skip;
SPECIAL		:(':' | '?'|'!'|','|'.'|';')+;
NEWLINE 	:'\r'?'\n';
