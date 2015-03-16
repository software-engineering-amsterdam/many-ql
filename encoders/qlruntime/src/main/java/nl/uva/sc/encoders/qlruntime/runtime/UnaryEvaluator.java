package nl.uva.sc.encoders.qlruntime.runtime;

import nl.uva.sc.encoders.ql.ast.operator.NotOperator;
import nl.uva.sc.encoders.ql.visitor.UnaryOperatorVisitor;
import nl.uva.sc.encoders.qlruntime.runtime.value.Value;

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
