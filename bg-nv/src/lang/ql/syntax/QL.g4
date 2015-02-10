grammar QL;

@parser::header
{
    import lang.ql.ast.expression.*;
}

form : 'form' Identifier '{' (statement)+ '}';

statement : question | ifCondition ;

question : QuestionType Identifier String (expression)? ;

ifCondition : 'if' '(' expression ')' '{' (statement)+ '}';

expression
    :'(' x=expression ')'
    | op=('-'|'+') x=expression
    | expression op=('*'|'/') expression
    | left=expression op=('-'|'+') right=expression
    //< > == !=
    //&& ||
    | a=Integer
    | a=String
    | a=Identifier
    ;

fragment Letter : [a-zA-Z];

fragment Digit : [0-9];

Boolean
   : 'true'
   | 'false'
   ;

QuestionType
   : 'boolean'
   | 'decimal'
   | 'integer'
   | 'string'
   | 'date'
   ;

Identifier : (Letter)(Letter|Digit|'_')*;

Decimal : Digit+ '.' Digit+ ;

Integer : Digit+ ;

String : Quotes .*? Quotes; //Handle escaping

fragment Test : '\\' Quotes | ~[Quotes] ;

Comment : '/*' .*? '*/' -> skip;

fragment Year : [1-2] Digit Digit Digit ;
fragment Month : [1-2] Digit ;
fragment Day : [1-31] ;

Date : Day '/' Month '/' Year ;

fragment Quotes : '“' | '"' | '”' | '\''; //Handle quotes properly

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip ;