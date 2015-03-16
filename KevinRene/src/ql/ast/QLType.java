package ql.ast;

import java.util.ArrayList;
import java.util.List;

import ql.ast.visitor.TypeVisitor;

public abstract class QLType implements QLNode {
	protected List<QLType> compatibleTypes;
	
	public QLType() {
		compatibleTypes = new ArrayList<QLType>();
	}
	
	public boolean compatibleWith(QLType type) {
		return compatibleTypes.contains(type);
	}
	
	/**
	 * @return the list of compatibilities
	 */
	public List<QLType> getCompatibilities() {
		return compatibleTypes;
	}

	public abstract <T> T accept(TypeVisitor<T> visitor);
	
	@Override
	public final int hashCode() {
		return this.getClass().getSimpleName().hashCode();
	}
	
	@Override
	public final boolean equals(Object comparisonObject) {
		return comparisonObject.hashCode() == hashCode();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}