grammar QL;

import Types, Ident, Comments;

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
