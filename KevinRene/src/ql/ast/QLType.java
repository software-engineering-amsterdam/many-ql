package ql.ast;

import ql.ast.type.QLBoolean;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;

public abstract class QLType implements QLNode {
	
	/**
	 * Addition
	 * 
	 * @param argument
	 * @return
	 */	
	public abstract boolean add(QLType argument);
	public abstract boolean addNumeric(QLNumeric argument);
	public abstract boolean addString(QLString argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean divide(QLType argument);
	public abstract boolean divideNumeric(QLNumeric argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean multiply(QLType argument);
	public abstract boolean multiplyNumeric(QLNumeric argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean subtract(QLType argument);
	public abstract boolean subtractNumeric(QLNumeric argument);
	
	/**
	 * Unary
	 * 
	 * @return
	 */
	public abstract boolean not();
	public abstract boolean positive();
	public abstract boolean negative();
	
	/**
	 * Relational
	 * @param rightValue
	 * @return
	 */
	public abstract boolean or(QLType rightValue);
	public abstract boolean orBoolean(QLBoolean argument);
	
	public abstract boolean notEqualTo(QLType argument);
	public abstract boolean notEqualToBoolean(QLBoolean argument);
	public abstract boolean notEqualToNumeric(QLNumeric argument);
	public abstract boolean notEqualToString(QLString argument);
	
	public abstract boolean lowerThan(QLType argument);
	public abstract boolean lowerThanNumeric(QLNumeric argument);
	
	public abstract boolean lowerOrEqual(QLType argument);
	public abstract boolean lowerOrEqualNumeric(QLNumeric argument);
	
	public abstract boolean greaterThan(QLType argument);
	public abstract boolean greaterThanNumeric(QLNumeric argument);
	
	public abstract boolean greaterOrEqual(QLType argument);
	public abstract boolean greaterOrEqualNumeric(QLNumeric argument);
	
	public abstract boolean equalTo(QLType argument);
	public abstract boolean equalToBoolean(QLBoolean argument);
	public abstract boolean equalToNumeric(QLNumeric argument);
	public abstract boolean equalToString(QLString argument);
	
	public abstract boolean and(QLType argument);
	public abstract boolean andBoolean(QLBoolean argument);
	
	public abstract boolean assign(QLType argument);
	public abstract boolean assignBoolean(QLBoolean argument);
	public abstract boolean assignNumeric(QLNumeric argument);
	public abstract boolean assignString(QLString argument);
	
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
	public abstract String toString();
}