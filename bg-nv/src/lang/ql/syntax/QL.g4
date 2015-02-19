grammar QL;

form : 'form' Identifier '{' (statement)+ '}';

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

Identifier : (Letter)(Letter|Digit|'_')*;

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (Epsilon | NonZeroDigit Digit* | ZeroDigit) '.' Digit+ ;

String: Quote StringCharacter+? Quote;

fragment StringCharacter
    : ~[\\]
    | EscapeSequence
    ;

fragment Quote: [n“”"'\\];
fragment EscapeSequence: '\\' Quote; //NOTE: removed btfr, we probably don't want to support that

fragment Epsilon : ; //just for readability

fragment Letter : Lowercase|Uppercase;
fragment Lowercase : [a-z];
fragment Uppercase : [a-zA-Z];

fragment Digit : ZeroDigit|NonZeroDigit;
fragment NonZeroDigit : [1-9];
fragment ZeroDigit : [0];

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip ;