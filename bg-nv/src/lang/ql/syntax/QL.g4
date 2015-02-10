grammar QL;

@parser::header
{
//package lang.ql.gen;
import lang.ql.ast.expression.*;

//import org.uva.sea.ql.ast.expr.*;
}

form : 'form' formId=Identifier '{' (statement)+ '}';

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
    | a=Integer //{ int parsedInt = java.lang.Integer.parseInt($a.getText()); $result = new IntegerExpression(parsedInt); }
    | a=String  //{ $result = new StringExpression($a.getText()); }
    | a=Identifier //{ $result = new VariableExpression($a.getText()); }
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