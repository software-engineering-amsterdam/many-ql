grammar Grammar;

@header
{
	import com.form.language.node.*;	
}

syntaxtree returns [AST ast]
: expression {$ast = $expression.ast; }
;

term returns [AST ast]
	:	IDENT {$ast = new IntValue(0);}
	|	'(' expression ')' {$ast = $expression.ast;}
	|	INTEGER {$ast = new IntValue(Integer.parseInt($INTEGER.text));}
	;
	
unary returns [AST ast]
	: 	{boolean positive = true; }	
		('+' | '-' {positive = !positive; })* term
		{
			$ast = $term.ast; 
			if (!positive)
				$ast = new Negation($ast);
		}
	;

mult returns [AST ast]
	:	op1=unary {$ast = $op1.ast; }
		( '*' op2=unary {$ast = new Multiplication($ast, $op2.ast);}
		| '/' op2=unary {$ast = new Division($ast, $op2.ast);}
		| 'mod' op2=unary {$ast = new Modulus($ast, $op2.ast);}
		)*
	;
	
expression returns [AST ast]
	:	op1=mult {$ast = $op1.ast; }
	 	(	'-' op2=unary {$ast = new Substraction($ast, $op2.ast);}
		| 	'+' op2=unary {$ast = new Addition($ast, $op2.ast);}
		)*
	;

relExpr returns [AST ast]
    :   lhs=expression { $ast = $lhs.ast; } 
    ( op=('<'|'<='|'>'|'>='|'=='|'!=') rhs=expression 
    { 
      if ($op.text.equals("<")) {
        $ast = new LessThen($ast, rhs);
      }
      if ($op.text.equals("<=")) {
        $ast = new LessOrEqualThen($ast, rhs);      
      }
      if ($op.text.equals(">")) {
        $ast = new GreaterThen($ast, rhs);
      }
      if ($op.text.equals(">=")) {
        $ast = new GreaterOrEqualThen($ast, rhs);      
      }
      if ($op.text.equals("==")) {
        $ast = new Equal($ast, rhs);
      }
      if ($op.text.equals("!=")) {
        $ast = new NotEqual($ast, rhs);
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
