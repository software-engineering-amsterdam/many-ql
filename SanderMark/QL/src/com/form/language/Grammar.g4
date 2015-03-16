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
	: 'question' STRING ID ':' type {$result = new Question($STRING.text, $ID.text, $type.result, new QLToken($ID.line,$ID.pos));}
	;
	
ifStatement returns [Statement result]
: IF exp=expression 'then' slist=statementList
  'end' {$result = new IfStatement($exp.result,$slist.result,  new QLToken($IF.line,$IF.pos));}
;

assignmentStatement returns [Statement result]
: ID ':=' type lit=literal {$result = new AssignmentStatement($ID.text, $type.result, $lit.result,new QLToken($ID.line,$ID.pos));}
;
	
expression returns [Expression result]
// Parentheses
  : LBRACE x=expression RBRACE				{ $result = $x.result;}
//	Unary
  |	op=(MINUS | EXCL) x=expression	{
  		switch($op.text){
			case "MINUS":  	$result = new Negation($x.result, new QLToken($MINUS.line,$MINUS.pos));
			case "EXCL": 	$result = new Not($x.result,new QLToken($EXCL.line,$EXCL.pos));
		}
  	}
 // Multiplication Division
  | l=expression op=(MULT | DIV) r=expression {
  	  	switch($op.text){
			case "MULT": 	$result = new Multiplication($l.result, $r.result, new QLToken($MULT.line,$MULT.pos));
			case "DIV": 	$result = new Division($l.result, $r.result, new QLToken($DIV.line,$DIV.pos));
		}
	}
 // Addition Substraction
  | l=expression op=(PLUS | MINUS) r=expression { 
	  	switch($op.text){
			case "PLUS":  	$result = new Addition($l.result, $r.result, new QLToken($PLUS.line,$PLUS.pos));
			case "MINUS": 	$result = new Substraction($l.result, $r.result, new QLToken($MINUS.line,$MINUS.pos));;
		}
	}
// Comparison
  | l=expression op=(EQ | GT | GTEQ | LT | LTEQ) r=expression {
  		switch($op.text){
			case "EQ": 		$result = new Equal($l.result, $r.result, new QLToken($EQ.line,$EQ.pos));
			case "GT": 		$result = new GreaterThan($l.result, $r.result, new QLToken($GT.line,$GT.pos));
			case "GTEQ": 	$result = new GreaterThanOrEqual($l.result, $r.result, new QLToken($GTEQ.line,$GTEQ.pos));
			case "LT": 		$result = new LessThan($l.result, $r.result, new QLToken($LT.line,$LT.pos));
			case "LTEQ": 	$result = new LessThanOrEqual($l.result, $r.result, new QLToken($LTEQ.line,$LTEQ.pos));
		}
	}
// Conjunct Disjunct
  |  l=expression op=(AND | OR) r=expression {
  	  	switch($op.text){
			case "AND": 	$result = new And($l.result, $r.result, new QLToken($AND.line,$AND.pos));
			case "OR": 		$result = new Or($l.result, $r.result, new QLToken($OR.line,$OR.pos));
		}
	}
// Literal
  | lit = literal	{ $result = $lit.result; }
  ;

literal returns [Expression result]
	: BOOLEAN	{$result = new BoolLiteral(Boolean.parseBoolean($BOOLEAN.text),new QLToken($BOOLEAN.line,$BOOLEAN.pos));}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text),new QLToken($INTEGER.line,$INTEGER.pos));}
	| STRING	{$result = new StringLiteral($STRING.text,new QLToken($STRING.line,$STRING.pos));}
	| ID	    {$result = new IdLiteral($ID.text,new QLToken($ID.line,$ID.pos));}
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
