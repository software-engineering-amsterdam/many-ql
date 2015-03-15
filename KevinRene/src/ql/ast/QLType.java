package ql.ast;

import java.util.List;
import java.util.stream.Collectors;

import ql.ast.visitor.ExpressionVisitor;

public abstract class QLType implements QLNode {
	protected List<Class<? extends QLType>> compatibleTypes;
	
	public QLType(List<Class<? extends QLType>> compatibleTypes) {
		this.compatibleTypes = compatibleTypes;
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public boolean compatibleWith(QLType type) {
		return this.compatibleTypes.contains(type.getClass());
	}
	
	/**
	 * @return the list of compatibilities
	 */
	public List<String> compatibilitiesAsStrings() {
		return compatibleTypes.stream()
				.map(ct -> ct.getSimpleName())
				.collect(Collectors.toList());
	}
	

	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract QLType getType();
}