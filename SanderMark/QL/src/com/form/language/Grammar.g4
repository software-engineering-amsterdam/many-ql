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
: IDENT ':=' add ';'
;

ifStatement returns [PrimitiveExpression pExp]
: 'if' add 'then' statement+
  ('else' statement+)?	
  'end' 'if' ';'
;


syntaxtree returns [PrimitiveExpression pExp]
: add {$pExp = $add.pExp; }
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
	:	op1=unary {$pExp = $op1.pExp; }
		( '*' op2=unary {$pExp = new Multiplication($pExp, $op2.pExp);}
		| '/' op2=unary {$pExp = new Division($pExp, $op2.pExp);}
		| 'mod' op2=unary {$pExp = new Modulus($pExp, $op2.pExp);}
		)*
	;
		
add returns [PrimitiveExpression pExp]
	:	op1=mult {$pExp = $op1.pExp; }
	 	(	'-' op2=unary {$pExp = new Substraction($pExp, $op2.pExp);}
		| 	'+' op2=unary {$pExp = new Addition($pExp, $op2.pExp);}
		)*
	;
	
rel returns [PrimitiveExpression pExp]
    :   lhs=add { $pExp=$lhs.result; } ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=add 
    { 
      if ($op.text.equals("<")) {
        $pExp = new LT($pExp, rhs);
      }
      if ($op.text.equals("<=")) {
        $pExp = new LEq($pExp, rhs);      
      }
      if ($op.text.equals(">")) {
        $pExp = new GT($pExp, rhs);
      }
      if ($op.text.equals(">=")) {
        $pExp = new GEq($pExp, rhs);      
      }
      if ($op.text.equals("==")) {
        $pExp = new Eq($pExp, rhs);
      }
      if ($op.text.equals("!=")) {
        $pExp = new NEq($pExp, rhs);
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
WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;
COMMENT : '//' .*? ('\n'|'\r') -> skip;
