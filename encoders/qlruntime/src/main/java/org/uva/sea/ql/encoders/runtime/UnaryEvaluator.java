package org.uva.sea.ql.encoders.runtime;

import org.uva.sea.ql.encoders.ast.operator.NotOperator;
import org.uva.sea.ql.encoders.runtime.value.Value;
import org.uva.sea.ql.encoders.visitor.UnaryOperatorVisitor;

public class UnaryEvaluator implements UnaryOperatorVisitor<Value> {

	private final Value value;

	public UnaryEvaluator(Value value) {
		this.value = value;
	}

	@Override
	public Value visit(NotOperator operator) {
		return value.not();
	}

}
