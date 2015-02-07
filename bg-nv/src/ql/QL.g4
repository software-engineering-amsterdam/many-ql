grammar QL;

form : 'form' ID '{' (question|stat)+ '}';
question : QuestionType ID String (expression)?;
stat : 'if' '(' expression ')' '{' (question|stat)+ '}';

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