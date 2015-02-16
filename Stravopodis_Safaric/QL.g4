/**
 * QL GRAMMAR
 */
grammar QL;

prog	: form+ ;

form	: FORM ID LC section+ RC ;

section	: SECTION ID LC quest+ RC;

quest 	: QUESTION STRING COLON LC (stat | expr | decl)* RC ;

stat : value
	 | ifStat
	 ;

decl : ID COLON expr SEMICOLON ;

expr		: ID ASSIGN expr											#Assign				// Assign
			| expr LOG_OR expr											#LogAnd 			// Logical and
			| expr LOG_AND expr											#LogOr 				// Logical or
			| expr (EQUAL | NOT_EQUAL) expr								#Equal_NotEqual		// Equal to
			| expr (LESS | LESS_EQUAL | GREATER | GREATER_EQUAL) expr	#LowerGreater
			| LP expr RP												#ParNesting			// Paranthesis nesting????
			| expr '^' <assoc=right> expr								#Exp 				// Exp
			| expr (MUL | DIV) expr 									#MulDiv 			// Multiplication					
			| expr (ADD | SUB) expr										#AddSub 			// Addition
			| literal													#ExprLit			//  ExpressionLiteral
			;

ifStat	: IF LP expr RP LC stat RC
		| IF LP expr RP LC stat RC ELSE LC stat RC;

value		: VALUE ASSIGN literal SEMICOLON ;	// E.g. value = true; 

literal		: BooleanLiteral
			| NumberLiteral
			| 'null'
			;
		
BooleanLiteral 	: 'true'
				| 'false'
				;

NumberLiteral	: '-'? INT
				| '-'? FLOAT
				;

/*primitiveType	: 'boolean'
				| 'float'
				| 'int'
				| 'string'
				;*/

WS			: [ \t\n\r]+ -> skip;

ID			: ID_LETTER (ID_LETTER | INT)* ;

ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

INT			: '0' | [1-9] [0-9]*  ;	// We cannot use [0-9]+ because this would mean that 01 + 3 would be acceptable

FLOAT		: INT+ '.' INT*
			| '.' INT+;

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

/* KEYWORDS - TOKENS */ 
QUESTION	: 'question' ;
FORM		: 'form' ;
SECTION 	: 'section' ;
BOOLEAN		: 'boolean' ;
VALUE		: 'value' ;
IF			: 'if';
THEN		: 'then';
ELSE		: 'else';
MUL			: '*' ;
DIV			: '/' ;
ADD			: '+' ;
SUB			: '-' ;
LP			: '(' ;
RP			: ')' ;
LC			: '{' ;
RC			: '}' ;
LESS		: '<' ;
LESS_EQUAL 	: '<=';
GREATER		: '>' ;
GREATER_EQUAL 	: '>=';
EQUAL  		: '==';
ASSIGN		: '=' ;
LOG_AND		: '&&';
LOG_OR		: '||';
NOT			: '!' ;
NOT_EQUAL	: '!=';
COLON     	: ':' ;
SEMICOLON   : ';' ;
COMMA       : ',' ;
 
/* semantic actions - next to the production rules, and then call the constructor */
/* create a class that implements the visitor - because ANTLR generates only visitor interface */
/* the listener ->  */
