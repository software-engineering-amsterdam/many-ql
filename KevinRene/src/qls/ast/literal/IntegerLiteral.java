package qls.ast.literal;

import ql.ast.expression.QLType;
import ql.ast.expression.type.QLInteger;
import ql.value.IntegerValue;
import qls.ast.Literal;
import qls.ast.visitor.Visitor;

public class IntegerLiteral extends Literal<IntegerValue> {	

	public IntegerLiteral(int value) {
		super(new IntegerValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLInteger();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
