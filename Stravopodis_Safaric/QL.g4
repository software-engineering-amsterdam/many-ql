/**
 * Define a grammar called Hello
 */
grammar QL;

quest : ID STRING COLON LC stat+ RC
	| 'if' LP expr RP LC quest RC
	;

stat : decl
	 | value
	 | ifStat
	 ;

decl : ID COLON expr SEMICOLON ;

/* add within expressions logical conditions */

/* in ANTLR there is a type for booleans  */
/* consider if (x == 3 && || y < 23 <= >= */
/* infix and prefix expressions */

expr		: expr MUL expr
			| expr DIV expr
			| expr ADD expr
			| expr SUB expr
			| literal
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

NumberLiteral	: INT
				| FLOAT
				;

primitiveType	: 'boolean'
				| 'float'
				| 'int'
				| 'string'
				;

WS			: [ \t\n\r]+ -> skip;

ID			: ID_LETTER (ID_LETTER | INT)* ;

ID_LETTER	: 'a'..'z' | 'A'..'Z' | '_' ;

INT			: [0-9]+ ;

FLOAT		: INT+ '.' INT*
			| '.' INT+;

STRING 		: '"'	(ESC|.)*? '"';
fragment
ESC			: '\\' | '\\\\' ;

LINE_COMMENT: '//' .*? '\n' -> skip;	// Single line comments
COMMENT		: '/*' .*? '*/' -> skip;	// Multi line comments

/* KEYWORDS - TOKENS */ 

BOOLEAN		: 'boolean';
VALUE		: 'value';
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
LOWER		: '<' ;
LOWER_EQUAL : '<=';
UPPER		: '>' ;
UPPER_EQUAL : '>=';
EQUAL  		: '==';
ASSIGN		: '=' ;
NOT			: '!' ;
NOT_EQUAL	: '!=';
COLON       : ':';
SEMICOLON   : ';';
COMMA       : ',';



/* semantic actions - next to the production rules, and then call the constructor */
/* create a class that implements the visitor - because ANTLR generates only visitor interface */




