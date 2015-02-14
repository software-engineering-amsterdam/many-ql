/** Grammars always start with a grammar header. This grammar is called
*   QL and must match the filename: QL.g4
*/
grammar QL;

/* Start rule */
questionnaire : stat* ;

stat : type ID STRING                                                 # Question
     | 'if' '(' bool_expr ')'  '{' stat* '}' ('else' '{' stat* '}')?  # IfStatement
	 ;

bool_expr : bool_expr '&&' bool_expr    # AndExpression
		  | bool_expr '||' bool_expr    # OrExpression
		  | bool_expr '==' bool_expr    # Equals
		  | num_expr '>' num_expr       # GreaterThan
          | num_expr '<' num_expr       # LessThan
		  /*

		  Using an identifier in a boolean expression should only possible if the identifier is of a boolean type itself.

		  How to accomplish this?

		  I see 2 alternatives:

		  1. Allow in the grammer identifiers of all types and check in the TypeChecker if the identifier is indeed of type boolean.
		  2. Define different ID tokens, one for each type. Ex: ID_BOOL, ID_STRING, ID_INT etc. etc.
		     In the 'bool_expr' parser rule you only allow ID_BOOL. 
			 The parser rule alternative 'Question' in the parser rule 'stat' (see above) needs to be split in alternatives for each type.

		  Alternative 1 keeps your grammer more simple but needs more checking later on.
		  Alternative 2 gives your languange more type safety (I assume) but will add more complexity in the grammer.

		  What is a good practice?
     	  
		  */
		  | ID                          # BooleanID
		  | BOOL                        # Boolean
		  ;

num_expr : num_expr ('*'|'/') num_expr # MultDiv
         | num_expr ('+'|'-') num_expr # AddSubstract
		 | ID                          # NumericID
		 | INT                         # Integer
		 ;

type : 'int' | 'string' | 'bool' ;


/*
 *   Lexer Rules
 */

INT    : '-'? [0-9]+ ;        // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;  // match anything in "..." (nongreedy)

/*
FLOAT : DIGIT+ '.' DIGIT*     // Shall we support floats?
      |        '.' DIGIT+
	  ;
DIGIT : [0-9] ;
*/
ESC : '' ; // '\\"' | '\\\\' ;

ID : [a-zA-Z]+ ;

/*
ID : ID_LETTER (ID_LETTER | DIGIT)* ;
ID_LETTER : [a-zA-Z] ;
*/

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out
