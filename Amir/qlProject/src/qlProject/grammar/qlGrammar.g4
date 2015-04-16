grammar qlGrammar; // rename to distinguish from Expr.g4

import CommonLexerRules;


form : statement+ ;

statement : ID STRING type	#basicQuestion
| ID STRING type '(' expr ')'  #computedQuestion // paren should be gone
| IF '(' expr ')' '{' ifPart+=statement+ (ELSE elsePart+=statement+)? '}' #conditionalQuestionsList;


	
type: BOOL_TYPE   # boolType  //extend to decimal date etc
    | INT_TYPE   # intType
    | STRING_TYPE    # strType
    ;
    
expr: SUB expr #negate // SUB or MIN
    | expr op=(MUL|DIV) expr     # MultiplyDivide
    | expr op=(ADD|SUB) expr     # AddSubtract  
    | NOT expr # not
    | expr AND expr #and
    | expr OR expr #or
    | expr GT expr # greaterThan
    | expr GEQ expr # greaterOrEq
    | expr LT expr # lessThan
    | expr LEQ expr # lessOrEq
    | expr EQ expr # equal
    | expr NEQ expr # unequal // STRING
    | expr CONCAT expr # concatenationExpression
    | INT                     # intLiteral
    | bLiteral=(TRUE|FALSE)	# boolLiteral
    | STRING                  # stringLiteral
    | ID                      # id
    | '(' expr ')'            # parens
    ;