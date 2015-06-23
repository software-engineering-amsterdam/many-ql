package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLString extends QLType {		
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return "string";
	}
	
	/**
	 * Type compatibilities
	 */

	@Override
	public boolean add(QLType argument) {
		return false;
	}

	@Override
	public boolean addNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean addString(QLString argument) {
		return false;
	}

	@Override
	public boolean divide(QLType argument) {
		return false;
	}

	@Override
	public boolean divideNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean multiply(QLType argument) {
		return false;
	}

	@Override
	public boolean multiplyNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean subtract(QLType argument) {
		return false;
	}

	@Override
	public boolean subtractNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean not() {
		return false;
	}

	@Override
	public boolean positive() {
		return false;
	}

	@Override
	public boolean negative() {
		return false;
	}

	@Override
	public boolean or(QLType rightValue) {
		return false;
	}

	@Override
	public boolean orBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean notEqualTo(QLType argument) {
		return argument.notEqualToString(this);
	}

	@Override
	public boolean notEqualToBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean notEqualToNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean notEqualToString(QLString argument) {
		return true;
	}

	@Override
	public boolean lowerThan(QLType argument) {
		return false;
	}

	@Override
	public boolean lowerThanNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean lowerOrEqual(QLType argument) {
		return false;
	}

	@Override
	public boolean lowerOrEqualNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean greaterThan(QLType argument) {
		return false;
	}

	@Override
	public boolean greaterThanNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean greaterOrEqual(QLType argument) {
		return false;
	}

	@Override
	public boolean greaterOrEqualNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean equalTo(QLType argument) {
		return argument.equalToString(this);
	}

	@Override
	public boolean equalToBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean equalToNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean equalToString(QLString argument) {
		return true;
	}

	@Override
	public boolean and(QLType argument) {
		return false;
	}

	@Override
	public boolean andBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean assign(QLType argument) {
		return argument.assignString(this);
	}

	@Override
	public boolean assignBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean assignNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean assignString(QLString argument) {
		return true;
	}
}
