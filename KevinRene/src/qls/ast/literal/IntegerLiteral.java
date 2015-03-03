package qls.ast.literal;

import qls.ast.Literal;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLInteger;
import qls.ast.visitor.Visitor;
import cons.value.IntegerValue;

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
