grammar Expr;

@header {
package org.tax.exprgen;
}

import Common;

myexpr : (expression NEWLINE)*;

literal :
	    DECIMAL             #DECIMALLiteral
    | 	INT                 #INTLiteral
	|   variable            #VarLiteral
	|   BOOLEANLITERAL      #BOOLLiteral	
    ;	


expression :
    literal                                             #LITExpr
    |   expression op=AND expression                       #ANDExpr
    |   expression op=OR expression                        #ORExpr
    |   op=BANG expression                                 #BANGExpr
    |   expression op=(GE | LE | GT | LT ) expression      #COMPExpr
    |   expression op=(EQUAL | NOTEQUAL) expression        #EQUALExpr
    |   expression op=(MUL | DIV | MOD) expression         #MULDIVExpr 
    |   expression op=(ADD | SUB) expression               #ADDSUBExpr
    |   (LPAR expression RPAR)                             #PARExpr
    ; 

