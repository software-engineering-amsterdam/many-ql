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
	: 'question' STRING ID TYPE {$result = new Question($STRING.text, $ID.text, $TYPE.text);}
	;
	
assignmentStatement returns [Statement result]
: ID ':=' lit=literal {$result = new AssignmentStatement($ID.text, $lit.result);}
;

ifStatement returns [Statement result]
: 'if' exp=expression 'then' slist=statementList
  'end' {$result = new IfStatement($exp.result,$slist.result);}
;

expression returns [Expression result]
	: LBRACE x=expression RBRACE				{ $result = $x.result;}
	| MINUS x=expression						{ $result = new Negation($x.result, $MINUS);}
	| EXCL x=expression							{ $result = new Not($x.result,$EXCL);}
	| l=expression MULT r=expression			{ $result = new Multiplication($l.result, $r.result, $MULT);}
	| l=expression DIV r=expression				{ $result = new Division($l.result, $r.result, $DIV);}
	| l=expression PLUS r=expression			{ $result = new Addition($l.result, $r.result, $PLUS); }
	| l=expression MINUS r=expression			{ $result = new Substraction($l.result, $r.result, $MINUS); }
	| l=expression EQ r=expression				{ $result = new Equal($l.result, $r.result, $EQ); }
	| l=expression GT r=expression				{ $result = new GreaterThan($l.result, $r.result, $GT); }
	| l=expression GTEQ r=expression			{ $result = new GreaterThanOrEqual($l.result, $r.result, $GTEQ); }
	| l=expression LT r=expression				{ $result = new LessThan($l.result, $r.result, $LT); }
	| l=expression LTEQ r=expression			{ $result = new LessThanOrEqual($l.result, $r.result, $LTEQ); }
	| l=expression AND r=expression				{ $result = new And($l.result, $r.result, $AND); }
	| l=expression OR r=expression				{ $result = new Or($l.result, $r.result, $OR); }
	| lit = literal								{ $result = $lit.result; }
	;



literal returns [Expression result]
	: BOOL		{$result = new BoolLiteral(Boolean.parseBoolean($BOOL.text),$BOOL);}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text),$INTEGER);}
	| STRING	{$result = new StringLiteral($STRING.text,$STRING);}
	;


MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;

BOOL : 'true' | 'false';
TYPE: 'Boolean' | 'String' | 'Number';
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
