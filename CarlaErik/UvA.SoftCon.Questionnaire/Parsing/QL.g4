/** Grammars always start with a grammar header. This grammar is called
*   QL and must match the filename: QL.g4
*/
grammar QL;

/* Start rule */
form : stat* ;


stat : TYPE ID STRING                                                       # Question
     | 'if' '(' expr ')' '{' then+=stat* '}' ('else' '{' else+=stat* '}')?  # IfStatement
	 | TYPE ID ('=' expr)?                                                  # Declaration
	 | ID '=' expr                                                          # Assignment
	 | 'show' expr                                                          # ShowExpression
	 ;

expr : '(' expr ')'                   # PrecedenceOverride
	 | expr ('*'|'/') expr            # MultiplyDivide
	 | expr ('+'|'-') expr            # AddSubstract
 	 | expr ('<'|'>'|'<='|'>=') expr  # Relational
	 | expr ('=='|'!=') expr          # Equality
     | expr '&&' expr                 # And
     | expr '||' expr                 # Or
	 | ID                             # Identifier
     | BOOL                           # BooleanLiteral
	 | INT                            # IntegerLiteral     
	 | DOUBLE                         # DoubleLiteral
	 | STRING                         # StringLiteral
	 ;

/*
 *   Lexer Rules
 */

INT    : '-'? DIGIT+ ;             // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       // match anything in "..." (nongreedy)
DOUBLE : '-'? DIGIT+ '.' DIGIT*    // Shall we support doubles?
       | '-'?        '.' DIGIT+
	   ;

TYPE : 'int' | 'string' | 'bool' ;

ID : LETTER (LETTER | DIGIT)* ;

// Helper tokens; (not vissible to the parser)
DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
ESC    : '\\"' | '\\\\' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out
