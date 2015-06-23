grammar qlGrammar; // rename to distinguish from Expr.g4

import CommonLexerRules;


form : questionsList+ ;

questionsList : question+ #unconditionalQuestionsList
| 'if' '(' expr ')' '{' ifPart+=question+ '}' ('else' elsePart+=question+)? #conditionalQuestionsList; 

question : ID STRING type	#basicQuestion
| ID STRING type '(' expr ')'  #computedQuestion; // paren should be gone
	
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
    | NOT expr # not
    | expr AND expr #and
    | expr OR expr #or
    |   INT                     # int
    |   ID                      # id
    |   '(' expr ')'            # parens
    |   (TRUE|FALSE)			# bool
//    | ('true'|'false') #bool
    ;