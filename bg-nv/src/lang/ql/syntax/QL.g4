grammar QL;

@parser::header
{
//package lang.ql.gen;
import lang.ql.ast.expression.*;

//import org.uva.sea.ql.ast.expr.*;
}

form : 'form' Identifier '{' (statement)+ '}';

statement : question | ifCondition ;

question : QuestionType Identifier String (expression)? ;

ifCondition : 'if' '(' expression ')' '{' (statement)+ '}';

expression returns [Expression result]
    :'(' x=expression ')'
    | op=('-'|'+') x=expression //Unary
    | expression op=('*'|'/') expression //Multiplication and division
    | left=expression op=('-'|'+') right=expression //{ if ($op.text.equals("+")) { $result = new SubtractionExpression($left.result, $right.result); } } //Binary addition and subtraction
    //< > == !=
    //&& ||
    | atom=Integer //{ int parsedInt = java.lang.Integer.parseInt($atom.getText()); $result = new IntegerExpression(parsedInt); }
    | atom=String  //{ $result = new StringExpression($atom.getText()); }
    | atom=Identifier //{ $result = new VariableExpression($atom.getText()); }
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

Identifier : (Letter)(Letter|Digit|'_')*;

Integer : Digit+ ;

String : '"' .*? '"';

Comment : '/*' .*? '*/' -> skip;

LineComment : '//' ~[\r\n]* -> skip;

WS : [ \t\r\n]+ -> skip ;