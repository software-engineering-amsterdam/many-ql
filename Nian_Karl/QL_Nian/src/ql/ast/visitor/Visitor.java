package ql.ast.visitor;

import ql.ast.expression.Parenthese;
import ql.ast.expression.binary.Plus;
import ql.ast.expression.literal.IntLiteral;

public interface Visitor<T> {

	public T visit(Plus node);
	
	public T visit(IntLiteral node);
	
	public T visit(Parenthese node);

}
