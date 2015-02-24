package ast.visitor;

import ast.expression.association.Parenthese;
import ast.expression.binary.And;
import ast.expression.binary.Divide;
import ast.expression.binary.Equal;
import ast.expression.binary.Greater;
import ast.expression.binary.GreaterEqual;
import ast.expression.binary.Less;
import ast.expression.binary.LessEqual;
import ast.expression.binary.Minus;
import ast.expression.binary.Multiply;
import ast.expression.binary.NotEqual;
import ast.expression.binary.Or;
import ast.expression.binary.Plus;
import ast.expression.literal.BoolLiteral;
import ast.expression.literal.Identifier;
import ast.expression.literal.IntLiteral;
import ast.expression.literal.StrLiteral;
import ast.expression.unary.Negative;
import ast.expression.unary.Not;
import ast.expression.unary.Positive;

public interface Visitor<T> {
	
	
	
	// Expressions
	public T visit(Not node);
	public T visit(Positive node);
	public T visit(Negative node);
	public T visit(Plus node);
	public T visit(Minus node);
	public T visit(Multiply node);
	public T visit(Divide node);
	public T visit(And node);
	public T visit(Or node);
	public T visit(Equal node);
	public T visit(NotEqual node);
	public T visit(Greater node);
	public T visit(GreaterEqual node);
	public T visit(Less node);
	public T visit(LessEqual node);
	public T visit(Identifier node);
	public T visit(IntLiteral node); 
	public T visit(BoolLiteral node);
	public T visit(StrLiteral node);
	public T visit(Parenthese node);
}
