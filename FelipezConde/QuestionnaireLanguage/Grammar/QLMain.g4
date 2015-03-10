grammar QLMain;

/* Form Structure */

 form           : 'form' formSection
;formSection    : '{' formObject* '}' 
;formObject     : question
                | conditional
; question       : 'question' id type label computed?
; conditional   : 'enable when' expression formSection
;

/* Types */ 
 type              : BOOL    #BoolType
                   | STRING  #StringType
                   | INT     #IntType
;value             : bool    #BoolValue
                   | string  #StringValue
                   | int     #IntValue
;bool              : TRUE    #TrueBool
                   | FALSE   #FalseBool

/* Literal Types*/
;string         : STRINGLITERAL
;int            : INTLITERAL
;id             : ALPHANUMERIC


;label : 'label' ':' STRINGLITERAL

;computed : 'computed' ':' computation

;computation : id            #ComputationId
             | value         #ComputationValue
             | expression    #ComputationExpression
             
/* Expression */
/*
expression : id
           | value
           | associative
           | nonAssociative
 I think this makes it easier, but we would have to label everything. computation would just become an expression though...
*/


;expression      : associative
                 | nonAssociative
                 ;

associative     : associative op= AND associative #AND
                | associative op= OR associative  #OR
                | associative op= MUL associative #MUL
                | associative op= DIV associative #DIV
                | associative op= SUB associative #SUB
                | associative op= ADD associative #ADD
                | unary                           #AssociativeUnary
                | value                           #AssociativeValue
                | id                              #AssociativeId
                ;

unary           : '!' expression      #NegateUnary
                | '(' expression ')'  #PriorityUnary
                ;

nonAssociative  : associative EQ associative      #EQ
                | associative NEQ associative     #NEQ
                | associative GT associative      #GT
                | associative GET associative     #GET
                | associative LT associative      #LT
                | associative LET associative     #LET
                | '(' expression ')'              #NonAssociativePriority
                | value                           #NonAssociativeValue
                | id                              #NonAssociativeId
                ;




/*Token Names*/
GT   : '>';
LT   : '<';
EQ   : '==';
NEQ  : '!=';
GET  : '>=';
LET  : '<=';
AND  : '&&';
OR   : '||';
NOT  : '!';

MUL  : '*';
DIV  : '/';
SUB  : '-';
ADD  : '+';

TRUE  : 'True';
FALSE : 'False';

BOOL   : 'bool';
STRING : 'string'; 
DATE   : 'date';
INT    : 'int';

/*Lexer rules*/
INTLITERAL     : '-'?[0-9]+;

YEAR  : [0-9]+;
MONTH : [0-9][0-9];
DAY   : [0-9][0-9];

ALPHANUMERIC : [a-zA-Z0-9]+;
STRINGLITERAL : '"' .*? '"';

/* White Space & Comments */
 WS             : (' ' | '\r' | '\n') -> channel(HIDDEN)
;BLOCK_COMMENT  : '/*' .*? '*/'       -> channel(HIDDEN)
;LINE_COMMENT   : '--' ~[\r\n]*       -> channel(HIDDEN)
;