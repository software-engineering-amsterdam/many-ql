package org.uva.sea.ql.encoders.runtime.operator;

import org.uva.sea.ql.encoders.runtime.value.Value;

public class NotOperator implements UnaryOperator {

	@Override
	public Value calculate(Value value) {
		return value.not();
	}
}
