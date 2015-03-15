package ql.ast;

import java.util.ArrayList;
import java.util.List;

import ql.ast.visitor.ExpressionVisitor;

public abstract class QLType implements QLNode {
	protected List<QLType> compatibleTypes;
	
	public QLType() {
		compatibleTypes = new ArrayList<QLType>();
	}
	
	public boolean compatibleWith(QLType type) {
		return compatibleTypes.stream()
				.map(compatibleType -> compatibleType.equals(type))
				.reduce(false, (x, y) -> x || y);
	}
	
	/**
	 * @return the list of compatibilities
	 */
	public List<QLType> getCompatibilities() {
		return compatibleTypes;
	}

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
	@Override
	public int hashCode() {
		return this.getClass().getSimpleName().hashCode();
	}
	
	@Override
	public abstract boolean equals(Object comparisonObject);
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}