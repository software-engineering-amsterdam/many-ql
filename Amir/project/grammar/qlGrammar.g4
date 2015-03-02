grammar qlGrammar; // rename to distinguish from Expr.g4

import CommonLexerRules;


form : box+ ;

box : question+ #normalBox
| 'if' '(' expr ')' '{' ifPart+=question+ '}' ('else' elsePart+=question+)? #conditionalBox; 

// delete : type+;

question : ID STRING type	#completeQuestion
| ID STRING type '(' expr ')'  #completeComputedQuestion; // paren should be gone
// | 'if' '(' condition ')' '{' question+ '}' ('else' question+)? #conditionalQuestion 
//| 'if' '(' bool_expr ')' '{' question+ '}' ('else' question+)? #bolexp; 

//stat:   expr NEWLINE                # printExpr
//    |   ID ':' STRING type NEWLINE  # bool
//    |   ID '=' expr NEWLINE         # assign
//    |   NEWLINE                     # blank
//    ;

	
type: BOOL_TYPE   # boolType  //extend to decimal date etc
    | INT_TYPE   # intType
    | STRING_TYPE    # strType
    ;
    
expr: expr MUL expr     # Multiply
    | expr DIV expr     # Divide
    | expr ADD expr     # Add
    | expr SUB expr     # Sub
    | expr '>' expr # bigger
    | expr '>=' expr # biggerEq
    | expr '<' expr # smaller
    | expr '<=' expr # smallerEq
    | expr '==' expr # equal
    | expr '!=' expr # unequal
    | expr AND expr #and
    | expr OR expr #or
//    |	  expr AND expr
//    |   expr OR expr
//    |
    |   INT                     # int
    |   ID                      # id
    |   '(' expr ')'            # parens
    |   (TRUE|FALSE)			# bool
//    | ('true'|'false') #bool
    ;

bool_expr: // expr '>' expr # bigger
//	| expr '>=' expr # biggerEq
//	| expr '<' expr # smaller
//	| expr '<=' expr # smallerEq
//	| expr '==' expr # equal
//	| expr '!=' expr # unequal
//	| 
	  bool_expr AND bool_expr # and2
	| bool_expr OR bool_expr # or2
	| NOT bool_expr # not
	| ID # boolId   // needs to actually be of a bool type
	| 'true' # true
	| 'false' # false
	;

// booleanExpr : 
// condition :  expr (GT|GEQ|LT|LEQ|EQ|NEQ) expr            # compare
//    |   NOT condition                                    # not
//    |   condition (AND) condition                             # and
//    |   condition (OR) condition                              # or
//	;

// NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
// WS  :   [ \t]+ -> skip ; // toss out whitespace
