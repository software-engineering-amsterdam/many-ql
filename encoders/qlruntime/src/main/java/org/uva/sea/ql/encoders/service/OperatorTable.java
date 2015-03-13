package org.uva.sea.ql.encoders.service;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.encoders.runtime.operator.AddOperator;
import org.uva.sea.ql.encoders.runtime.operator.AndOperator;
import org.uva.sea.ql.encoders.runtime.operator.BinaryOperator;
import org.uva.sea.ql.encoders.runtime.operator.DivideOperator;
import org.uva.sea.ql.encoders.runtime.operator.GreaterOrEqualOperator;
import org.uva.sea.ql.encoders.runtime.operator.GreaterThanOperator;
import org.uva.sea.ql.encoders.runtime.operator.LessOrEqualOperator;
import org.uva.sea.ql.encoders.runtime.operator.LessThanOperator;
import org.uva.sea.ql.encoders.runtime.operator.MultiplyOperator;
import org.uva.sea.ql.encoders.runtime.operator.NotOperator;
import org.uva.sea.ql.encoders.runtime.operator.OrOperator;
import org.uva.sea.ql.encoders.runtime.operator.SubstractOperator;
import org.uva.sea.ql.encoders.runtime.operator.UnaryOperator;

public class OperatorTable {

	private final Map<String, BinaryOperator> binaryOperators;
	private final Map<String, UnaryOperator> unaryOperators;

	public OperatorTable() {
		binaryOperators = constructBinaryOperators();
		unaryOperators = constructUnaryOperators();
	}

	private Map<String, BinaryOperator> constructBinaryOperators() {
		Map<String, BinaryOperator> binaryOperators = new HashMap<>();
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
		return binaryOperators;
	}

	private Map<String, UnaryOperator> constructUnaryOperators() {
		Map<String, UnaryOperator> unaryOperators = new HashMap<>();
		unaryOperators.put("!", new NotOperator());
		return unaryOperators;
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
