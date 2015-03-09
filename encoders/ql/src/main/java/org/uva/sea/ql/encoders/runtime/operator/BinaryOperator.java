package org.uva.sea.ql.encoders.runtime.operator;

import org.uva.sea.ql.encoders.runtime.value.Value;

public interface BinaryOperator {

	Value calculate(Value leftValue, Value rightValue);

}
