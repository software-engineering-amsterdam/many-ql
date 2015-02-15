/** Grammars always start with a grammar header. This grammar is called
*   QL and must match the filename: QL.g4
*/
grammar QL;

/* Start rule */
questionnaire : stat* ;

// I had to use different names for 2 collections of stat rules 
stat : type ID STRING                                                         # Question
     | 'if' '(' bool_expr ')'  '{' stat_if* '}' ('else' '{' stat_else* '}')?  # IfStatement
	 ;
	 /* Which is better? 
	    1 general rule:
	 | type ID '=' expr            # Assignment
	   -or- multiple rules, one for each type?
	 | 'int' ID '=' num_expr       # IntegerAssignment
	 | 'bool' ID '=' bool_expr     # BooleanAssignment
	 | 'string' ID '=' string_expr # StringAssignment
	 */

// These are only necessary to differentiate the 2 collections in the visitor class.
stat_if   : stat ;
stat_else : stat ;

// To-do: Precedence order of operations should reflect those of common languages.
bool_expr : '(' bool_expr ')'           # Precedence // To-do: How to implement this? This should only affect the way the AST will be constructed?
          | bool_expr '&&' bool_expr    # AndExpression
		  | bool_expr '||' bool_expr    # OrExpression
		  | bool_expr '==' bool_expr    # BooleanEquals
		  | num_expr  '==' num_expr     # NumericEquals
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
		  | ID                          # BooleanId
		  | BOOL                        # BooleanLiteral
		  ;

num_expr : num_expr ('*'|'/') num_expr # MultDiv
         | num_expr ('+'|'-') num_expr # AddSubstract
		 | ID                          # NumericId
		 | INT                         # IntegerLiteral
		 ;

string_expr : string_expr '+' string_expr # Concatination
            | ID                          # StringId
			| STRING                      # StringLiteral
			;

type : 'int' | 'string' | 'bool' ;


/*
 *   Lexer Rules
 */

 // Keywords should be defined first

INT    : '-'? DIGIT+ ;             // Define token INT as one or more digit
BOOL   : 'true' | 'false' ;  
STRING : '"' (ESC|.)*? '"' ;       // match anything in "..." (nongreedy)
DOUBLE : '-'? DIGIT+ '.' DIGIT*    // Shall we support doubles?
       | '-'?        '.' DIGIT+
	   ;

ID : LETTER (LETTER | DIGIT)* ;

// Helper tokens; (not vissible to the parser)
DIGIT  : [0-9] ;
LETTER : [a-zA-Z] ;
ESC    : '\\"' | '\\\\' ;

LINE_COMMENT : '//' .*? '\r'? '\n' -> skip ;
COMMENT      : '/*' .*? '*/'       -> skip ;
WS           : [ \t\r\n]+          -> skip ; // Define whitespace rule, toss it out
