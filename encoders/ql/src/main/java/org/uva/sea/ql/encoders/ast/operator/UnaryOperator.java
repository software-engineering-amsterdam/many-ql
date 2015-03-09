package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public interface UnaryOperator {

	<T extends DataType<V>, V> V calculate(T dataType, V value);
}
