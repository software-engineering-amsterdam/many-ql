grammar TaZQL;

options {
	language = Java;
}

//@header {
//	package com.antlr4.zarina.tazql;
//}


r  : ID; 
ID  : [a-z]+ ;
WS  : [ \t\r\n]+ -> skip ;

