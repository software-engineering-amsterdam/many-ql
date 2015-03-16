package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.operator.AddOperator;
import org.uva.sea.ql.encoders.ast.operator.AndOperator;
import org.uva.sea.ql.encoders.ast.operator.DivideOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterThanOperator;
import org.uva.sea.ql.encoders.ast.operator.LessOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.LessThanOperator;
import org.uva.sea.ql.encoders.ast.operator.MultiplyOperator;
import org.uva.sea.ql.encoders.ast.operator.OrOperator;
import org.uva.sea.ql.encoders.ast.operator.SubstractOperator;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.visitor.BinaryOperatorVisitor;

public class BinaryEvaluator implements BinaryOperatorVisitor<Value> {

	private final Value leftValue;

	private final Value rightValue;

	public BinaryEvaluator(Value leftValue, Value rightValue) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
	}

	@Override
	public Value visit(AddOperator operator) {
		return leftValue.add(rightValue);
	}

	@Override
	public Value visit(AndOperator operator) {
		return leftValue.and(rightValue);
	}

	@Override
	public Value visit(DivideOperator operator) {
		return leftValue.divide(rightValue);
	}

	@Override
	public Value visit(GreaterOrEqualOperator operator) {
		return leftValue.greaterOrEqual(rightValue);
	}

	@Override
	public Value visit(GreaterThanOperator operator) {
		return leftValue.greaterThan(rightValue);
	}

	@Override
	public Value visit(LessOrEqualOperator operator) {
		return leftValue.lessOrEqual(rightValue);
	}

	@Override
	public Value visit(MultiplyOperator operator) {
		return leftValue.multiply(rightValue);
	}

	@Override
	public Value visit(OrOperator operator) {
		return leftValue.or(rightValue);
	}

	@Override
	public Value visit(SubstractOperator operator) {
		return leftValue.substract(rightValue);
	}

	@Override
	public Value visit(LessThanOperator lessThanOperator) {
		return leftValue.lessThan(rightValue);
	}

}
