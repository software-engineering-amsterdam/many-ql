package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public class NotOperator implements UnaryOperator {

	@Override
	public <T extends DataType<V>, V> V calculate(T dataType, V value) {
		return dataType.not(value);
	}

}
