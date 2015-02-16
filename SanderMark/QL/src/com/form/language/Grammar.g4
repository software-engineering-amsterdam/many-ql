grammar Grammar;

@header
{
	import com.form.language.ast.*;
	import com.form.language.ast.expression.*;
	import com.form.language.ast.expression.math.*;	
	import com.form.language.ast.values.*;
}

statement
: assignmentStatement
| ifStatement
;

assignmentStatement
: IDENT ':=' expression ';'
;

ifStatement returns [PrimitiveExpression pExp]
: 'if' expression 'then' statement+
  ('else' statement+)?	
  'end' 'if' ';'
;


syntaxtree returns [PrimitiveExpression pExp]
: expression {$pExp = $expression.pExp; }
;

term returns [PrimitiveExpression pExp]
	:	IDENT {$pExp = new IntLiteral(0);}
	|	'(' expression ')' {$pExp = $expression.pExp;}
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
	:	op1=unary {$pExp = $op1.pExp; }
		( '*' op2=unary {$pExp = new Multiplication($pExp, $op2.pExp);}
		| '/' op2=unary {$pExp = new Division($pExp, $op2.pExp);}
		| 'mod' op2=unary {$pExp = new Modulus($pExp, $op2.pExp);}
		)*
	;
	
expression returns [PrimitiveExpression pExp]
	:	op1=mult {$pExp = $op1.pExp; }
	 	(	'-' op2=unary {$pExp = new Substraction($pExp, $op2.pExp);}
		| 	'+' op2=unary {$pExp = new Addition($pExp, $op2.pExp);}
		)*
	;


MULTILINE_COMMENT : '/*' .*? '*/' -> skip ;

CHAR_LITERAL
	:	'\'' . '\'' {setText(getText().substring(1,2));}
	;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';
INTEGER : DIGIT+ ;
IDENT : LETTER (LETTER | DIGIT)*;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;
