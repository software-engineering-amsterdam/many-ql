package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLBoolean extends QLType {
	
	@Override
	public <T> T accept(TypeVisitor<T> visitor) {	
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "boolean";
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
		return true;
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
	public boolean or(QLType argument) {
		return argument.orBoolean(this);
	}

	@Override
	public boolean orBoolean(QLBoolean argument) {
		return true;
	}

	@Override
	public boolean notEqualTo(QLType argument) {
		return argument.notEqualToBoolean(this);
	}

	@Override
	public boolean notEqualToBoolean(QLBoolean argument) {
		return true;
	}

	@Override
	public boolean notEqualToNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean notEqualToString(QLString argument) {
		return false;
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
		return argument.equalToBoolean(this);
	}

	@Override
	public boolean equalToBoolean(QLBoolean argument) {
		return true;
	}

	@Override
	public boolean equalToNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean equalToString(QLString argument) {
		return false; 
	}

	@Override
	public boolean and(QLType argument) {
		return argument.andBoolean(this);
	}

	@Override
	public boolean andBoolean(QLBoolean argument) {
		return true;
	}

	@Override
	public boolean assign(QLType argument) {
		return argument.assignBoolean(this);
	}

	@Override
	public boolean assignBoolean(QLBoolean argument) {
		return true;
	}

	@Override
	public boolean assignNumeric(QLNumeric argument) {
		return false;
	}

	@Override
	public boolean assignString(QLString argument) {
		return false;
	}
}
