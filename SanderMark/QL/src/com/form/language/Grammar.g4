grammar Grammar;

@header
{
	import com.form.language.ast.*;
	import com.form.language.ast.expression.*;
	import com.form.language.ast.expression.math.*;	
	import com.form.language.ast.expression.literal.*;	
	import com.form.language.ast.expression.logic.*;
	import com.form.language.ast.statement.*;
	import com.form.language.ast.values.*;
	import com.form.language.ast.type.*;
	import com.form.language.error.QLToken;
	import com.form.language.memory.*;
}

form returns [Form result]
	: 'form' ID '{' stmts=statementList {$result = new Form($ID.text,$stmts.result);}'}' 
;

statementList returns [List<Statement> result]
	@init {List<Statement> stmts = new ArrayList<Statement>();}
	: (stmt=statement {stmts.add($stmt.result);})+ 
	{$result = stmts;}
	;

statement returns [Statement result]
: Astmt=assignmentStatement {$result = $Astmt.result;}
| Istmt=ifStatement {$result = $Istmt.result;}
| Qstmt=question {$result = $Qstmt.result;}
;

question returns [Question result]
	: 'question' STRING ID ':' type {$result = new Question($STRING.text, $ID.text, $type.result, new QLToken($ID.getLine(),$ID.getCharPositionInLine()));}
	;
	
ifStatement returns [Statement result]
: IF exp=expression 'then' slist=statementList
  'end' {$result = new IfStatement($exp.result,$slist.result,  new QLToken($IF.getLine(),$IF.getCharPositionInLine()));}
;

assignmentStatement returns [Statement result]
: ID ':=' type lit=literal {$result = new AssignmentStatement($ID.text, $type.result, $lit.result,new QLToken($ID.getLine(),$ID.getCharPositionInLine()));}
;
	
expression returns [Expression result]
  : LBRACE x=expression RBRACE				{ $result = $x.result;}
//	Unary
  |	(
  		  MINUS 	{ $result = new Negation($x.result, new QLToken($MINUS.getLine(),$MINUS.getCharPositionInLine()));}
		| EXCL 		{ $result = new Not($x.result,new QLToken($EXCL.getLine(),$EXCL.getCharPositionInLine()));})
	x=expression	
// 	Binary
  | l=expression 
	// Multiplication Division
		(	MULT 	{ $result = new Multiplication($l.result, $r.result, new QLToken($MULT.getLine(),$MULT.getCharPositionInLine()));}
		  | DIV 	{ $result = new Division($l.result, $r.result, new QLToken($DIV.getLine(),$DIV.getCharPositionInLine()));})
	// Addition Substraction
	|	(	PLUS	{ $result = new Addition($l.result, $r.result, new QLToken($PLUS.getLine(),$PLUS.getCharPositionInLine())); } 
		  | MINUS	{ $result = new Substraction($l.result, $r.result, new QLToken($MINUS.getLine(),$MINUS.getCharPositionInLine())); })
	// Comparison
	|	(	EQ 		{ $result = new Equal($l.result, $r.result, new QLToken($EQ.getLine(),$EQ.getCharPositionInLine())); }
		  |	GT 		{ $result = new GreaterThan($l.result, $r.result, new QLToken($GT.getLine(),$GT.getCharPositionInLine())); }
		  |	GTEQ 	{ $result = new GreaterThanOrEqual($l.result, $r.result, new QLToken($GTEQ.getLine(),$GTEQ.getCharPositionInLine())); }
		  |	LT 		{ $result = new LessThan($l.result, $r.result, new QLToken($LT.getLine(),$LT.getCharPositionInLine())); }
		  |	LTEQ 	{ $result = new LessThanOrEqual($l.result, $r.result, new QLToken($LTEQ.getLine(),$LTEQ.getCharPositionInLine())); })
	// Conjuct Disjunct
	|	(	AND 	{ $result = new And($l.result, $r.result, new QLToken($AND.getLine(),$AND.getCharPositionInLine())); }
		  |	OR 		{ $result = new Or($l.result, $r.result, new QLToken($OR.getLine(),$OR.getCharPositionInLine())); })
 	r=expression	
// Literal		
  | lit = literal	{ $result = $lit.result; }
  ;

literal returns [Expression result]
	: BOOLEAN	{$result = new BoolLiteral(Boolean.parseBoolean($BOOLEAN.text),new QLToken($BOOLEAN.getLine(),$BOOLEAN.getCharPositionInLine()));}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text),new QLToken($INTEGER.getLine(),$INTEGER.getCharPositionInLine()));}
	| STRING	{$result = new StringLiteral($STRING.text,new QLToken($STRING.getLine(),$STRING.getCharPositionInLine()));}
	| ID	    {$result = new IdLiteral($ID.text,new QLToken($ID.getLine(),$ID.getCharPositionInLine()));}
	;

type returns [Type result]
	: 'Boolean' {$result = new BoolType();}
	| 'String'  {$result = new StringType();}
	| 'Number'  {$result = new IntType();};

MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;

IF: 'if';
BOOLEAN : 'true' | 'false';
STRING: '"'.*?'"';
INTEGER : [0-9]+;

ID : ([a-z][A-Za-z0-9]+);
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;

OR: '||';
AND: '&&';
LTEQ: '<=';
LT: '<';
GTEQ: '>=';
GT: '>';
EQ: '==';
PLUS: '+';
DIV: '/';
MULT: '*';
EXCL: '!';
MINUS: '-';
RBRACE: ')';
LBRACE: '(';
