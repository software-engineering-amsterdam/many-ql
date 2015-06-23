grammar QL;

/*
 *	  Parser Rules
 */

/* Start rule */
form : stat* ;

stat : ID STRING TYPE ('=' expr)?                                           # Question
     | 'if' '(' expr ')' '{' then+=stat* '}' ('else' '{' else+=stat* '}')?  # IfStatement
	 ;

expr : '(' expr ')'                   # PrecedenceOverride
	 | '!' expr                       # Negation
	 | expr ('*'|'/') expr            # MultiplyDivide
	 | expr ('+'|'-') expr            # AddSubstract
 	 | expr ('<'|'>'|'<='|'>=') expr  # Relational
	 | expr ('=='|'!=') expr          # Equality
     | expr '&&' expr                 # And
     | expr '||' expr                 # Or
	 | ID                             # Identifier
     | BOOL                           # BooleanLiteral
	 | INT                            # IntegerLiteral     
	 | STRING                         # StringLiteral
	 | DATE                           # DateLiteral
	 ;

/*
 *   Lexer Rules
 */

INT    : '-'? DIGIT+ ;             // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       // match anything between "..." (nongreedy)
DATE   : '[' DAY '-' MONTH '-' YEAR ']' 
       | '[today]'
	   | '[yesterday]'
	   | '[tomorrow]'
       ;

TYPE : 'int' | 'string' | 'bool' | 'date';

ID : LETTER (LETTER | DIGIT)* ;

// Helper tokens; (not vissible to the parser)
DAY    : DIGIT DIGIT? ;
MONTH  : DIGIT DIGIT? ;
YEAR   : DIGIT DIGIT DIGIT DIGIT ;

DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
ESC    : '\\"' | '\\\\' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out
