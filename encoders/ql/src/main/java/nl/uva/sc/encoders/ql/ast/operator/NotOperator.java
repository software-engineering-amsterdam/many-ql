package nl.uva.sc.encoders.ql.ast.operator;

import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.visitor.UnaryOperatorVisitor;

public class NotOperator implements UnaryOperator {

	@Override
	public <T> T accept(UnaryOperatorVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public boolean supports(DataType dataType) {
		return dataType instanceof BooleanType;
	}
}
