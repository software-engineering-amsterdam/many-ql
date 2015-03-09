package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public class AndOperator implements BinaryOperator {

	@Override
	public <T extends DataType<V>, V> V calculate(T dataType, V leftValue, V rightValue) {
		return dataType.and(leftValue, rightValue);
	}

}
