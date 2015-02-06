grammar qlGrammar; // rename to distinguish from Expr.g4

import CommonLexerRules;


form : box+ ;

box : question+;

question : ID STRING type	#completeQuestion
| ID STRING type '(' expr ')'  #completeComputedQuestion
| 'if' condition '{' box '}' ('else' box)? #conditionalQuestion; 

//stat:   expr NEWLINE                # printExpr
//    |   ID ':' STRING type NEWLINE  # bool
//    |   ID '=' expr NEWLINE         # assign
//    |   NEWLINE                     # blank
//    ;


type: BOOL_TYPE   # boolType  //extend to decimal date etc
    | INT_TYPE   # intType
    | STRING_TYPE    # strType
    ;
    
expr:   expr (MUL|DIV) expr     # MulDiv
    |   expr (ADD|SUB) expr     # AddSub
    |   INT                     # int
//    |   ID                      # id
    |   '(' expr ')'            # parens
    |   (TRUE|FALSE)			# bool
    ;

condition :  expr (GT|GEQ|LT|LEQ|EQ|NEQ) expr            # compare
    |   NOT condition                                    # not
    |   condition (AND) condition                             # and
    |   condition (OR) condition                              # or
	;

// NEWLINE:'\r'? '\n' ;     // return newlines to parser (is end-statement signal)
// WS  :   [ \t]+ -> skip ; // toss out whitespace
