package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.QLType;
import ql.ast.expression.Unary;
import ql.ast.type.QLFloat;
import ql.ast.type.QLNumeric;
import ql.ast.visitor.ExpressionVisitor;

public class Negation extends Unary {
	public Negation(Expression operand) {
		super(operand, "-");
		compatibleTypes.add(new QLNumeric());
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	//TODO: Add a superclass for numeric types.
	@Override
	public QLType getType() {
		return new QLFloat();
	}
}
