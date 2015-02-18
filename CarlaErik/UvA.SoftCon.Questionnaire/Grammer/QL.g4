/** Grammars always start with a grammar header. This grammar is called
*   QL and must match the filename: QL.g4
*/
grammar QL;

/* Start rule */
questionnaire : stat* ;

stat : type ID                  # Question
     | 'if' '(' bool_expr ')'  '{' stat* '}' ('else' '{' stat* '}')?  # IfStatment
	 ;

bool_expr : bool_expr '&&' bool_expr    # AndExpression
		  | bool_expr '||' bool_expr    # OrExpression
		  | bool_expr '==' bool_expr    # Equals
		  | num_expr '>' num_expr       # GreaterThan
          | num_expr '<' num_expr       # LessThan
		  | ID
		  | BOOL
		  ;

num_expr : 
		 | num_expr '==' num_expr # Equals // Can we reuse a name in another parser rule?
		 | ID
		 | INT
		 ;

type : 'int' | 'string' | 'bool'


INT    : '-'? [0-9]+ ;        // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;  // match anything in "..." (nongreedy)

FLOAT : DIGIT+ '.' DIGIT*     // Shall we support floats?
      |        '.' DIGIT+
	  ;
DIGIT : [0-9] ;
ESC : '\\"' | '\\\\' ;



ID : ID_LETTER (ID_LETTER | DIGIT)* ;
ID_LETTER : [a-zA-Z] ;


LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out