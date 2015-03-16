package ql.ast;

import java.util.ArrayList;
import java.util.List;

import ql.ast.visitor.ExpressionVisitor;

public abstract class Expression implements QLNode {	
	private final List<Expression> operands;
	protected final List<QLType> compatibleTypes;
	
	public Expression(List<Expression> operands) {
		this.operands = operands;
		compatibleTypes = new ArrayList<QLType>();
	}
	
	public boolean compatibleWith(QLType type) {
		return compatibleTypes.contains(type);
	}
	public List<QLType> getCompatibilities() {
		return compatibleTypes;
	}
	
	/**
	 * Translates the value and the values of its children to a String.
	 * @return The resulting concatenation as a string
	 */	
	@Override
	public abstract String toString();
	
	public List<Expression> getOperands() {
		return this.operands;
	}
	
	public abstract QLType getType();

	public abstract <T> T accept(ExpressionVisitor<T> visitor);

}
