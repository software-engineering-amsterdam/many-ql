grammar QL;

form : 'form' ID '{' (statement)+ '}';

statement : question | ifCondition ;

question : QuestionType ID String (expression)? ;

ifCondition : 'if' '(' expression ')' '{' (statement)+ '}';

expression
    :'(' x=expression ')'
    | '-' x=expression
    | '+' x=expression
    | Integer
    | ID
    | expression '+' expression
    ;

fragment Letter : [a-zA-Z];

fragment Digit : [0-9];

Keywords
   : 'true'
   | 'false'
   ;

QuestionType
   : 'boolean'
   | 'integer'
   | 'string'
   | 'date'
   ;

ID : (Letter)(Letter|Digit|'_')*;

Integer : Digit+ ;

String : '"' .*? '"';

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip ;