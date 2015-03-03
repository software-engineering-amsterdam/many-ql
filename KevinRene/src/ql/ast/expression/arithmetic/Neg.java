package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.expression.QLType;
import ql.ast.expression.Unary;
import ql.ast.expression.type.QLFloat;
import ql.ast.visitor.Visitor;

public class Neg extends Unary {
	public Neg(Expression operand) {
		super(operand, "-");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	//TODO: Add a superclass for numeric types.
	@Override
	public QLType getType() {
		return new QLFloat();
	}
}
