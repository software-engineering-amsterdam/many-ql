grammar Grammar;

@header
{
	import com.form.language.ast.*;
	import com.form.language.ast.expression.*;
	import com.form.language.ast.expression.math.*;	
	import com.form.language.ast.expression.literal.*;	
	import com.form.language.ast.expression.logic.*;
	import com.form.language.ast.expression.variable.*;
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
: Istmt=ifStatement {$result = $Istmt.result;}
| Qstmt=question {$result = $Qstmt.result;}
;

question returns [Question result]
	: 'question' STRING ID ':' type {$result = new Question($STRING.text, $ID.text, $type.result, new QLToken($ID.line,$ID.pos));}
	;
	
ifStatement returns [Statement result]
: IF exp=expression 'then' slist=statementList
  'end' {$result = new IfStatement($exp.result,$slist.result,  new QLToken($IF.line,$IF.pos));}
;

expression returns [Expression result]
// Parentheses
  : '(' x=expression ')' { $result = $x.result;}
//	Unary
  |	op=('-' | '!') x=expression	{
  		switch($op.text){
			case "-":  	$result = new Negation($x.result, new QLToken($op.line,$op.pos));
						break;
			case "!": 	$result = new Not($x.result,new QLToken($op.line,$op.pos));
						break;
		}
  	}
// Multiplication Division
  | l=expression op=('*' | '/') r=expression {
  	  	switch($op.text){
			case "*": 	$result = new Multiplication($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case "/": 	$result = new Division($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
		}
	}
// Addition Substraction
  | l=expression op=('+' | '-') r=expression { 
	  	switch($op.text){
			case "+":  	$result = new Addition($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case "-": 	$result = new Substraction($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
		}
	}
// Comparison
  | l=expression op=('==' | '>' | '>=' | '<' | '<=' ) r=expression {
  		switch($op.text){
			case "==": 	$result = new Equal($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case ">": 	$result = new GreaterThan($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case ">=": 	$result = new GreaterThanOrEqual($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case "<": 	$result = new LessThan($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case "<=": 	$result = new LessThanOrEqual($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
		}
	}
// Conjunct Disjunct
  |  l=expression op=('&&' | '||') r=expression {
  	  	switch($op.text){
			case "&&": 	$result = new And($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
			case "||": 	$result = new Or($l.result, $r.result, new QLToken($op.line,$op.pos));
						break;
		}
	}
// Literal
  | lit = literal	{ $result = $lit.result; }
  ;

literal returns [Expression result]
	: BOOLEAN	{$result = new BoolLiteral(Boolean.parseBoolean($BOOLEAN.text),new QLToken($BOOLEAN.line,$BOOLEAN.pos));}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text),new QLToken($INTEGER.line,$INTEGER.pos));}
	| STRING	{$result = new StringLiteral($STRING.text,new QLToken($STRING.line,$STRING.pos));}
	| ID	    {$result = new Reference($ID.text,new QLToken($ID.line,$ID.pos));}
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