grammar QL;


@parser::header
{
	import org.uva.sea.ql.model.expression.*;
	import org.uva.sea.ql.model.expression.commonexpression.*;
	import org.uva.sea.ql.model.expression.booleanexpression.*;
	import org.uva.sea.ql.model.expression.mathexpression.*;
	import org.uva.sea.ql.model.literal.*;
	import org.uva.sea.ql.model.value.*;
}

@lexer::header
{
//	import org.uva.sea.ql.model.expression.*;
//	import org.uva.sea.ql.model.expression.mathexpression.*;
//	import org.uva.sea.ql.model.expression.booleanexpression.*;
//	import org.uva.sea.ql.model.expression.commonexpression.*;
}

// Parser rules
form : 'form' identifier LEFT_BRACES question (question | statement)* RIGHT_BRACES;

question: questionType identifier stringLiteral SEMICOLON;

statement:	IF LEFT_PARENTHESES expr RIGHT_PARENTHESES LEFT_BRACES (question)+ RIGHT_BRACES;

expr: 
	literal
	| expr AND expr
	| expr OR expr
	| expr EQUAL_COND expr
	| expr GREATER expr
	| expr EQUAL_GREATER expr
	| expr EQUAL expr
	| expr EQUAL_SMALLER expr
	| expr SMALLER expr
	| expr PLUS expr 
	| expr MINUS expr 
	| expr MULTIPLY expr 
	| expr DEVIDE expr 
;
//=========================================
    
   
unExpr returns [AbstractValue result]
    :  '+' x=unExpr { $result = new PositiveExpression($x.result); }
    |  '-' x=unExpr { $result = new NegativeExpression($x.result); }
    |  '!' x=unExpr { $result = new NotExpression($x.result); }
//    |  x=expr    { $result = $x.result; }
    ;
    
    
mulExpr returns [Expression result]
    :   lhs=unExpr { $result=$lhs.result; } ( op=( '*' | '/' ) rhs=unExpr 
    { 
      if ($op.text.equals("*")) {
        $result = new MulExpression($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new DivExpression($result, rhs);      
      }
    })*
    ;
    
  
addExpr returns [Expression result]
    :   lhs=mulExpr { $result=$lhs.result; } ( op=('+' | '-') rhs=mulExpr
    { 
      if ($op.text.equals("+")) {
        $result = new AddExpression($result, rhs);
      }
      if ($op.text.equals("-")) {
        $result = new SubExpression($result, rhs);      
      }
    })*
    ;
  
relExpr returns [Expression result]
    :   lhs=addExpr { $result=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=addExpr 
    { 
      if ($op.text.equals("<")) {
        $result = new LessExpression($result, rhs);
      }
      if ($op.text.equals("<=")) {
        $result = new LessOrEqualExpression($result, rhs);      
      }
      if ($op.text.equals(">")) {
        $result = new GreaterExpression($result, rhs);
      }
      if ($op.text.equals(">=")) {
        $result = new GreaterOrEqualExpression($result, rhs);      
      }
      if ($op.text.equals("==")) {
        $result = new EqualExpression($result, rhs);
      }
      if ($op.text.equals("!=")) {
        $result = new NegationExpression($result, rhs);
      }
    })*
    ;
    
andExpr returns [AbstractValue result]
    :   lhs=relExpr { $result=$lhs.result; } ( '&&' rhs=relExpr { $result = new AndExpression($result, rhs); } )*
    ;
    

orExpr returns [AbstractValue result]
    :   lhs=andExpr { $result = $lhs.result; } ( '||' rhs=andExpr { $result = new OrExpression.java($result, rhs); } )*
    ;


//=========================================

questionType :INT | STR | CUR | BOOL;

identifier:	Ident;

literal
	 : numberLiteral
 	 | booleanLiteral
 	 | stringLiteral
 	 | identifier
	;
	
booleanLiteral: 
	bool;

numberLiteral
	: Int
	| Float
	;

stringLiteral
	: Str
	;

bool: TRUE | FALSE;


// Lexer rules
// Tokens

INT:			'Int';
STR:			'Str';
CUR:			'Cur';
BOOL:			'Bool';
TRUE: 			'true';
FALSE: 			'false';
IF: 			'if';
OR:				'||';
AND:			'&&';
EQUAL:			'=';
GREATER: 		'>';
EQUAL_GREATER: 	'>='; 
EQUAL_COND:		'==';
EQUAL_SMALLER: 	'<=';
SMALLER: 		'<';
LEFT_BRACES:	'{';
RIGHT_BRACES:	'}';
LEFT_PARENTHESES:	'(';
RIGHT_PARENTHESES:	')';
COLON:			':';
SEMICOLON:		';';
PLUS:			'+';
MINUS:			'-';
DEVIDE:			'/';
MULTIPLY:		'*';

Int: [1-9][0-9]*;

Str: '"' .*? '"';

Float: Int'.'Int;

//Date: ('0');

WhiteSpace  :(' ' | '\t' | '\n' | '\r') -> skip;

MultiComment : '/*' .*? '*/' -> skip;

SingleComment: '//' .*? '\n' -> skip;

Ident: [a-zA-Z][a-zA-Z0-9_]*;


