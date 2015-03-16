package ql.ast;

import java.util.ArrayList;
import java.util.List;

import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLString;
import ql.ast.visitor.TypeVisitor;

public abstract class QLType implements QLNode {
	protected List<QLType> compatibleTypes;
	
	public QLType() {
		compatibleTypes = new ArrayList<QLType>();
	}
	
	/**
	 * Addition
	 * 
	 * @param argument
	 * @return
	 */	
	public abstract boolean add(QLType argument);
	public abstract boolean addInteger(QLInteger argument);
	public abstract boolean addFloat(QLFloat argument);
	public abstract boolean addString(QLString argument);
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean divide(QLType argument);
	public abstract boolean divideInteger(QLInteger argument);
	public abstract boolean divideFloat(QLFloat argument);
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean multiply(QLType argument);
	public abstract boolean multiplyInteger(QLInteger argument);	
	public abstract boolean multiplyFloat(QLFloat argument);
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public abstract boolean subtract(QLType argument);
	public abstract boolean subtractInteger(QLInteger argument);
	public abstract boolean subtractFloat(QLFloat argument);
	
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
	public abstract boolean notEqualToInteger(QLInteger argument);
	public abstract boolean notEqualToFloat(QLFloat argument);
	public abstract boolean notEqualToString(QLString argument);
	
	public abstract boolean lowerThan(QLType argument);
	public abstract boolean lowerThanInteger(QLInteger argument);
	public abstract boolean lowerThanFloat(QLFloat argument);
	
	public abstract boolean lowerOrEqual(QLType argument);
	public abstract boolean lowerOrEqualInteger(QLInteger argument);
	public abstract boolean lowerOrEqualFloat(QLFloat argument);
	
	public abstract boolean greaterThan(QLType argument);
	public abstract boolean greaterThanInteger(QLInteger argument);
	public abstract boolean greaterThanFloat(QLFloat argument);
	
	public abstract boolean greaterOrEqual(QLType argument);
	public abstract boolean greaterOrEqualThanInteger(QLInteger argument);
	public abstract boolean greaterOrEqualThanFloat(QLFloat argument);
	
	public abstract boolean equalTo(QLType argument);
	public abstract boolean equalToBoolean(QLBoolean argument);
	public abstract boolean equalToInteger(QLInteger argument);
	public abstract boolean equalToFloat(QLFloat argument);
	public abstract boolean equalToString(QLString argument);
	
	public abstract boolean and(QLType argument);
	public abstract boolean andBoolean(QLBoolean argument);
	
	
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