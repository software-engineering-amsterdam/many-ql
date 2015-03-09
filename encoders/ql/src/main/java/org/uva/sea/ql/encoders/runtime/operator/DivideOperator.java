package org.uva.sea.ql.encoders.runtime.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public class DivideOperator implements BinaryOperator {

	@Override
	public <T extends DataType<V>, V> V calculate(T dataType, V leftValue, V rightValue) {
		return dataType.divide(leftValue, rightValue);
	}
}
