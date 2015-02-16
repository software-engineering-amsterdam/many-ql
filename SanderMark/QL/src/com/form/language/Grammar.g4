grammar Grammar;

@header
{
	import com.form.language.ast.*;
	import com.form.language.ast.expression.*;
	import com.form.language.ast.expression.math.*;	
	import com.form.language.ast.expression.literal.*;	
	import com.form.language.ast.expression.logic.*;
	import com.form.language.ast.values.*;
}

statement
: assignmentStatement
| ifStatement
;

assignmentStatement
: IDENT ':=' add ';'
;

ifStatement returns [PrimitiveExpression pExp]
: 'if' add 'then' statement+
  ('else' statement+)?	
  'end' 'if' ';'
;


/*
syntaxtree returns [PrimitiveExpression pExp]
: add {$pExp = $add.pExp; }
;

*/

expression returns [PrimitiveExpression result]
	: '(' x=expression ')'	{ $result = $x.result;}
	| '-' x=expression		{ $result = new Negation($x.result);}
	| l=expression '*' r=expression		{ $result = new Multiplication($l.result, $r.result);}
	| l=expression '/' r=expression		{ $result = new Division($l.result, $r.result);}
	| l=expression '+' r=expression		{ $result = new Addition($l.result, $r.result); }
	| l=expression '-' r=expression		{ $result = new Substraction($l.result, $r.result); }
	| l=expression '==' r=expression	{ $result = new Equal($l.result, $r.result); }
	| l=expression '>' r=expression		{ $result = new GreaterThan($l.result, $r.result); }
	| l=expression '>=' r=expression	{ $result = new GreaterThanOrEqual($l.result, $r.result); }
	| l=expression '<' r=expression		{ $result = new LessThan($l.result, $r.result); }
	| l=expression '=<' r=expression	{ $result = new LessThanOrEqual($l.result, $r.result); }
	| lit = literal						{ $result = $lit.result; }
	;

literal returns [PrimitiveExpression result]
	: BOOL		{$result = new BoolLiteral(Boolean.parseBoolean($BOOL.text));}
	| INTEGER	{$result = new IntLiteral(Integer.parseInt($INTEGER.text));}
	;


term returns [PrimitiveExpression pExp]
	:	IDENT {$pExp = new IntLiteral(0);}
	|	'(' add ')' {$pExp = $add.pExp;}
	|	INTEGER {$pExp = new IntLiteral(Integer.parseInt($INTEGER.text));}
	;
		
unary returns [PrimitiveExpression pExp]
	: 	{boolean positive = true; }	
		('+' | '-' {positive = !positive; })* term
		{
			$pExp = $term.pExp; 
			if (!positive)
				$pExp = new Negation($pExp);
		}
	;

mult returns [PrimitiveExpression pExp]
    :   lhs=unary { $pExp=$lhs.pExp; } ( op=( '*' | '/' ) rhs=unary 
    { 
      if ($op.text.equals("*")) {
        $pExp = new Multiplication($pExp, $rhs.pExp);
      }
      if ($op.text.equals("/")) {
        $pExp = new Division($pExp, $rhs.pExp);      
      }
    })*
    ;

		
add returns [PrimitiveExpression pExp]
    :   lhs=mult { $pExp=$lhs.pExp; } ( op=('+' | '-') rhs=mult
    { 
      if ($op.text.equals("+")) {
        $pExp = new Addition($pExp, $rhs.pExp);
      }
      if ($op.text.equals("-")) {
        $pExp = new Substraction($pExp, $rhs.pExp);      
      }
    })*
    ;		
	
rel returns [PrimitiveExpression pExp]
    :   lhs=add { $pExp=$lhs.pExp; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=add 
    { 
      if ($op.text.equals("<")) {
        $pExp = new LessThan($pExp, $rhs.pExp);
      }
      if ($op.text.equals("<=")) {
        $pExp = new LessThanOrEqual($pExp, $rhs.pExp);      
      }
      if ($op.text.equals(">")) {
        $pExp = new GreaterThan($pExp, $rhs.pExp);
      }
      if ($op.text.equals(">=")) {
        $pExp = new GreaterThanOrEqual($pExp, $rhs.pExp);      
      }
      if ($op.text.equals("==")) {
        $pExp = new Equal($pExp, $rhs.pExp);
      }
      if ($op.text.equals("!=")) {
        $pExp = new NotEqual($pExp, $rhs.pExp);
      }
    })*
    ;


MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;

CHAR_LITERAL
	:	'\'' . '\'' {setText(getText().substring(1,2));}
	;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;
IDENT : LETTER (LETTER | DIGIT)*;
BOOL : 'true' | 'false';
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;
