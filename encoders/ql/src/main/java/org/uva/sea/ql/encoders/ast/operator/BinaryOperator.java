package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public interface BinaryOperator {

	<T extends DataType<V>, V> V calculate(T dataType, V leftValue, V rightValue);
}
