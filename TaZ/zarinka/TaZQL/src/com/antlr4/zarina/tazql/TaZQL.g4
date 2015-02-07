grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}

parse      : questionLabel+ EOF;
//form : questionLabel+;
 
//primitiveType  : 'boolean' | 'char' | 'int' | 'double';   
//booleanOption :   'true' | 'false'; 

//unfinished business, tricky one...
//statement	: questionLabel |
//			  'if' '(' condition = booleanOption ')' '{' then=relatedQuestion '}'
//			  'else'relatedQuestion;


//element : questionLabel+;

questionLabel : NUMBER FILETEXT;
//relatedQuestion: questionR = FILETEXT;

NUMBER		: '0'..'9'+ ('.' '0'..'9'+)*;
TEXT  		: '"' ('a'..'z'|'A'..'Z'|NUMBER|'_'|WS)* '"'; 
FILETEXT	:'['(ID |SPECIAL|NUMBER|WS)*']';	
ID 			:('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'_'|'0'..'9')*; 
WS  		: (' ' | '\t' | '\n' | '\r')+ -> skip;
SPECIAL		:(':' | '?'|'!'|','|'.'|';')+;
NEWLINE :	'\r'?'\n';
