grammar QL;

form : 'form' Identifier '{' (statement)+ '}' ;

statement : question | ifCondition ;

question : QuestionType Identifier String (expression)? ;

ifCondition
    : 'if' '(' expression ')' '{' (statement)+ '}'
    | 'if' '(' expression ')' statement
    ;

expression
    : '(' parenthesis=expression ')'
    | operator=('-'|'+'|'!') operand=expression
    | left=expression operator=('*'|'/') right=expression
    | left=expression operator=('-'|'+') right=expression
    | left=expression operator=('<'|'>'|'<='|'>='|'=='|'!=') right=expression
    | left=expression operator=('&&'|'||') right=expression
    | primary=Boolean
    | primary=Decimal
    | primary=String
    | primary=Identifier
    | primary=Integer
    ;

fragment StringCharacter : EscapeSequence | ~[\\] ;

fragment Quote : ["] ;

fragment EscapeSequence : '\\' Quote ;

fragment Letter : [a-zA-Z] ;

fragment Digit : ZeroDigit|NonZeroDigit ;

fragment NonZeroDigit : [1-9] ;

fragment ZeroDigit : [0] ;

QuestionType
   : 'boolean'
   | 'decimal'
   | 'integer'
   | 'string'
   ;

Boolean
   : 'true'
   | 'false'
   ;

Identifier : (Letter)(Letter|Digit|'_')* ;

Integer : (ZeroDigit | NonZeroDigit Digit*) ;

Decimal : ( NonZeroDigit Digit* | ZeroDigit? ) '.' Digit+ ;

String : Quote StringCharacter*? Quote ;

Comment : '/*' .*? '*/' -> skip ;

LineComment : '//' ~[\r\n]* -> skip ;

WS : [ \t\r\n]+ -> skip ;