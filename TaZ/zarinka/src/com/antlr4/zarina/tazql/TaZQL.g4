grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}

parse       : form+ EOF;
form		: formSection;

formSection : 'FORM' formId '<' question+ '>';
formId : ID;
 
type  : 'boolean' | ID | 'int' | 'double' | choise;   
choise :   'true' | 'false'; 

question	: questionLabel 
			| 'if' '(' choise ')' '<' question+ '>'; //'else' question+;
			  

questionLabel : NUMBER FILETEXT type;


NUMBER		: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT  		: '"' ('a'..'z'|'A'..'Z'|NUMBER|'_'|WS)* '"'; 
FILETEXT	:'['(ID |SPECIAL|NUMBER|WS)*']';	
ID 			:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  		: (' ' | '\t' | '\n' | '\r')+ -> skip;
SPECIAL		:(':' | '?'|'!'|','|'.'|';')+;
NEWLINE :	'\r'?'\n';
