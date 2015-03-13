package org.uva.sea.ql.encoders.runtime.operator;

import org.uva.sea.ql.encoders.runtime.value.Value;

public interface UnaryOperator {

	Value calculate(Value value);
}
