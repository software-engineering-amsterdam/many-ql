/** Grammars always start with a grammar header. This grammar is called
*   QLS and must match the filename: QLS.g4
*/
grammar QLS;


//Rules
form : stat* ;

styleSheed:    'StyleSheed' STRING											# LayoutStyle 
          ;									    
questionnaire: 'Questionnaire:'  STRING '{'stat*'}'  
			 ;																# PageName

stat : ID ('widget' expr)?                                                  # Question 
     | 'if' '(' expr ')' '{' then+=stat* '}' ('else' '{' else+=stat* '}')?  # IfStatement
	 | 'Section' STRING '{' stat* '}'										# Section
	 | 'default' TYPE (stat*)?	 											# Default
	 ;

expr : expr':'expr					  # PropertiesDefault
	 |'(' expr ')'                    # PrecedenceOverride
     | expr '++'                      # Increment
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
	 ;

/*
 *   Lexer Rules
 */

INT    : '-'? DIGIT+ ;             // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       // match anything in "..." (nongreedy)

TYPE : 'int' | 'string' | 'bool' ;

ID : LETTER (LETTER | DIGIT)* ;

// Helper tokens; (not vissible to the parser)
DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
ESC    : '\\"' | '\\\\' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out     