package nl.uva.sc.encoders.qlruntime.evaluator;

import nl.uva.sc.encoders.ql.ast.operator.AddOperator;
import nl.uva.sc.encoders.ql.ast.operator.AndOperator;
import nl.uva.sc.encoders.ql.ast.operator.DivideOperator;
import nl.uva.sc.encoders.ql.ast.operator.EqualsOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.GreaterThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessOrEqualOperator;
import nl.uva.sc.encoders.ql.ast.operator.LessThanOperator;
import nl.uva.sc.encoders.ql.ast.operator.MultiplyOperator;
import nl.uva.sc.encoders.ql.ast.operator.NotEqualsOperator;
import nl.uva.sc.encoders.ql.ast.operator.OrOperator;
import nl.uva.sc.encoders.ql.ast.operator.SubstractOperator;
import nl.uva.sc.encoders.ql.visitor.BinaryOperatorVisitor;
import nl.uva.sc.encoders.qlruntime.model.value.Value;

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

	@Override
	public Value visit(EqualsOperator equalsOperator) {
		return leftValue.equal(rightValue);
	}

	@Override
	public Value visit(NotEqualsOperator notEqualsOperator) {
		return leftValue.notEqual(rightValue);
	}

}
