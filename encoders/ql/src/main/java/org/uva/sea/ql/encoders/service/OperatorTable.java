package org.uva.sea.ql.encoders.service;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.encoders.ast.operator.AddOperator;
import org.uva.sea.ql.encoders.ast.operator.AndOperator;
import org.uva.sea.ql.encoders.ast.operator.BinaryOperator;
import org.uva.sea.ql.encoders.ast.operator.DivideOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.GreaterThanOperator;
import org.uva.sea.ql.encoders.ast.operator.LessOrEqualOperator;
import org.uva.sea.ql.encoders.ast.operator.LessThanOperator;
import org.uva.sea.ql.encoders.ast.operator.MultiplyOperator;
import org.uva.sea.ql.encoders.ast.operator.NotOperator;
import org.uva.sea.ql.encoders.ast.operator.OrOperator;
import org.uva.sea.ql.encoders.ast.operator.SubstractOperator;
import org.uva.sea.ql.encoders.ast.operator.UnaryOperator;

public class OperatorTable {

	private final Map<String, BinaryOperator> binaryOperators = new HashMap<>();
	private final Map<String, UnaryOperator> unaryOperators = new HashMap<>();

	public OperatorTable() {
		constructBinaryOperators();
		constructUnaryOperators();
	}

	private void constructBinaryOperators() {
		binaryOperators.put("*", new MultiplyOperator());
		binaryOperators.put("/", new DivideOperator());
		binaryOperators.put("+", new AddOperator());
		binaryOperators.put("-", new SubstractOperator());
		binaryOperators.put("&&", new AndOperator());
		binaryOperators.put("||", new OrOperator());
		binaryOperators.put("<", new LessThanOperator());
		binaryOperators.put(">", new GreaterThanOperator());
		binaryOperators.put("<=", new LessOrEqualOperator());
		binaryOperators.put(">=", new GreaterOrEqualOperator());
	}

	private void constructUnaryOperators() {
		unaryOperators.put("!", new NotOperator());
	}

	public BinaryOperator getBinaryOperator(String operator) {
		BinaryOperator binaryOperator = binaryOperators.get(operator);
		if (binaryOperator == null) {
			throw new IllegalStateException("Binary operator " + operator + " is not supported");
		}
		return binaryOperator;
	}

	public UnaryOperator getUnaryOperator(String operator) {
		UnaryOperator unaryOperator = unaryOperators.get(operator);
		if (unaryOperator == null) {
			throw new IllegalStateException("Binary operator " + operator + " is not supported");
		}
		return unaryOperator;
	}
}
