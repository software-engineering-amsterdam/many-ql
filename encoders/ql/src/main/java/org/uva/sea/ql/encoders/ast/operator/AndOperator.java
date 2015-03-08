package org.uva.sea.ql.encoders.ast.operator;

import org.uva.sea.ql.encoders.ast.type.DataType;

public class AndOperator implements BinaryOperator {

	@Override
	public <T extends DataType> T calculate(T leftValue, T rightValue) {
		return leftValue.and(rightValue);
	}

}
