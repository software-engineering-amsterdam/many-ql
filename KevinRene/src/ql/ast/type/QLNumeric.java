package ql.ast.type;

import ql.ast.QLType;
import ql.ast.visitor.TypeVisitor;

public class QLNumeric extends QLType {

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {		
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "numeric";
	}

	/**
	 * Type compatibilities
	 */

	@Override
	public boolean add(QLType argument) {
		return argument.addNumeric(this);
	}

	@Override
	public boolean addNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean addString(QLString argument) {
		return false;
	}

	@Override
	public boolean divide(QLType argument) {
		return argument.divideNumeric(this);
	}

	@Override
	public boolean divideNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean multiply(QLType argument) {
		return argument.multiplyNumeric(this);
	}

	@Override
	public boolean multiplyNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean subtract(QLType argument) {
		return argument.subtractNumeric(this);
	}

	@Override
	public boolean subtractNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean not() {
		return false;
	}

	@Override
	public boolean positive() {
		return true;
	}

	@Override
	public boolean negative() {
		return true;
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
		return argument.notEqualToNumeric(this);
	}

	@Override
	public boolean notEqualToBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean notEqualToNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean notEqualToString(QLString argument) {
		return false;
	}

	@Override
	public boolean lowerThan(QLType argument) {
		return argument.lowerThanNumeric(this);
	}

	@Override
	public boolean lowerThanNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean lowerOrEqual(QLType argument) {
		return argument.lowerOrEqualNumeric(this);
	}

	@Override
	public boolean lowerOrEqualNumeric(QLNumeric argument) {
		return true;
	}


	@Override
	public boolean greaterThan(QLType argument) {
		return argument.greaterThanNumeric(this);
	}

	@Override
	public boolean greaterThanNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean greaterOrEqual(QLType argument) {
		return argument.greaterOrEqualNumeric(this);
	}

	@Override
	public boolean greaterOrEqualNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean equalTo(QLType argument) {
		return argument.equalToNumeric(this);
	}

	@Override
	public boolean equalToBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean equalToNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean equalToString(QLString argument) {
		return false;
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
		return argument.assignNumeric(this);
	}

	@Override
	public boolean assignBoolean(QLBoolean argument) {
		return false;
	}

	@Override
	public boolean assignNumeric(QLNumeric argument) {
		return true;
	}

	@Override
	public boolean assignString(QLString argument) {
		return false;
	}
}
