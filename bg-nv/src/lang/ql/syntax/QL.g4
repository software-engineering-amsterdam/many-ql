grammar QL;

form : 'form' Identifier '{' (statement)+ '}';

statement : question | ifCondition ;

question : QuestionType Identifier String (expression)? ;

ifCondition : 'if' '(' expression ')' '{' (statement)+ '}';
expressionList : expression +;

expression
    : '(' x=expression ')'
    | operator=('-'|'+') operand=expression
    | left=expression operator=('*'|'/'|'%') right=expression
    | left=expression operator=('-'|'+') right=expression
    | left=expression operator=('<'|'>'|'<='|'>=') right=expression
    | left=expression operator=('=='|'!=') right=expression
    | left=expression operator='&&' right=expression
    | left=expression operator='||' right=expression
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

Identifier : (Letter)(Letter|Digit|'_')*;

Boolean
   : 'true'
   | 'false'
   ;

Date : 'date:' (Day '-' Month '-' Year | Day '.' Month '.' Year | Year '/' Month '/' Day);

Integer : (ZeroDigit | NonZeroDigit Digit*);

Decimal : (Epsilon | NonZeroDigit Digit* | ZeroDigit) '.' Digit+ ;

String : Quotes (Epsilon | .*? ~['\\']) Quotes; //Handle escaping

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

fragment Quotes : '“' | '"' | '”' | '\''; //Handle quotes properly

Comment : '/*' .*? '*/' -> channel(HIDDEN);
LineComment : '//' ~[\r\n]* -> channel(HIDDEN);

WS : [ \t\r\n]+ -> channel(HIDDEN) ;