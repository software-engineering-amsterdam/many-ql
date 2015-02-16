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
}

form returns [Form result]
	: 'form' ID '{' stmts=statementList {new Form($ID.text,$stmts.result);}'}'
;

statementList returns [List<Statement> result]
	@init {List<Statement> stmts = new ArrayList<Statement>();}
	: (stmt=statement {stmts.add($stmt.result);})+ 
	{$result = stmts;}
	;

statement returns [Statement result]
: Astmt=assignmentStatement {$result = $Astmt.result;}
| Istmt=ifStatement {$result = $Istmt.result;}
;


assignmentStatement returns [Statement result]
: ID ':=' lit=literal {$result = new AssignmentStatement($ID.text, $lit.result);}
;

ifStatement returns [Statement result]
: 'if' exp=expression 'then' slist=statementList
  'end' {$result = new IfStatement($exp.result,$slist.result);}
;

expression returns [PrimitiveExpression result]
	: '(' x=expression ')'				{ $result = $x.result;}
	| '-' x=expression					{ $result = new Negation($x.result);}
	| '!' x=expression					{ $result = new Not($x.result);}
	| l=expression '*' r=expression		{ $result = new Multiplication($l.result, $r.result);}
	| l=expression '/' r=expression		{ $result = new Division($l.result, $r.result);}
	| l=expression '+' r=expression		{ $result = new Addition($l.result, $r.result); }
	| l=expression '-' r=expression		{ $result = new Substraction($l.result, $r.result); }
	| l=expression '==' r=expression	{ $result = new Equal($l.result, $r.result); }
	| l=expression '>' r=expression		{ $result = new GreaterThan($l.result, $r.result); }
	| l=expression '>=' r=expression	{ $result = new GreaterThanOrEqual($l.result, $r.result); }
	| l=expression '<' r=expression		{ $result = new LessThan($l.result, $r.result); }
	| l=expression '=<' r=expression	{ $result = new LessThanOrEqual($l.result, $r.result); }
	| l=expression '&&' r=expression	{ $result = new And($l.result, $r.result); }
	| l=expression '||' r=expression	{ $result = new Or($l.result, $r.result); }
	| lit = literal						{ $result = $lit.result; }
	;

literal returns [PrimitiveExpression result]
	: BOOL		{$result = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text));}
	;


MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;

INTEGER : [0-9]+;
BOOL : 'true' | 'false';

ID : ([a-z][A-Za-z0-9]+);

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;
