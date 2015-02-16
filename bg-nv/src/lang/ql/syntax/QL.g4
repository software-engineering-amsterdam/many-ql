grammar QL;

form : 'form' Identifier '{' (statement)+ '}';

statement : question | ifCondition ;

question : QuestionType Identifier String (expression)? ;

ifCondition
    : 'if' '(' expression ')' '{' (statement)+ '}'
    | 'if' '(' expression ')' statement
    ;

expressionList : expression +; //TODO: remove later, testing purposes only

expression
    : '(' x=expression ')'
    | operator=('-'|'+') operand=expression
    | left=expression operator=('*'|'/'|'%') right=expression
    | left=expression operator=('-'|'+') right=expression
    | left=expression operator=('<'|'>'|'<='|'>=') right=expression
    | left=expression operator=('=='|'!=') right=expression
    | left=expression operator='&&' right=expression
    | left=expression operator='||' right=expression
    | primary=Boolean
    | primary=Date
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
   | 'date'
   ;

Boolean
   : 'true'
   | 'false'
   ;

Identifier : (Letter)(Letter|Digit|'_')*;

Date : 'date:' (Day '-' Month '-' Year | Day '.' Month '.' Year | Year '/' Month '/' Day);

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (Epsilon | NonZeroDigit Digit* | ZeroDigit) '.' Digit+ ;

String
    : '"' StringCharacter+? '"'
    | '\'' StringCharacter+? '\''
    | '“' StringCharacter+? '”'
    ;

fragment StringCharacter
    : ~[\\]
    | EscapeSequence
    ;

fragment EscapeSequence: '\\' [n“”"'\\]; //NOTE: removed btfr, we probably don't want to support that

fragment Epsilon : ; //just for readability

fragment Letter : Lowercase|Uppercase;
fragment Lowercase : [a-z];
fragment Uppercase : [a-zA-Z];

fragment Digit : ZeroDigit|NonZeroDigit;
fragment NonZeroDigit : [1-9];
fragment ZeroDigit : [0];

fragment Year : [1-2] Digit Digit Digit ;
fragment Month : [1-12];
fragment Day : [1-31] ;

Comment : '/*' .*? '*/' -> channel(HIDDEN);
LineComment : '//' ~[\r\n]* -> channel(HIDDEN);

WS : [ \t\r\n]+ -> channel(HIDDEN) ;