package ast.visitor;

import ast.expression.association.Parenthese;
import ast.expression.binary.Plus;
import ast.expression.literal.IntLiteral;

public interface Visitor<T> {
	
	public T visit(Plus node);
	public T visit(IntLiteral node); 
	public T visit(Parenthese node);
}
