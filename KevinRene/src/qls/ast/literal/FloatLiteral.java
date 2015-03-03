package qls.ast.literal;

import ql.ast.expression.QLType;
import ql.ast.expression.type.QLFloat;
import ql.value.FloatValue;
import qls.ast.Literal;
import qls.ast.visitor.Visitor;

public class FloatLiteral extends Literal<FloatValue> {	

	public FloatLiteral(float value) {
		super(new FloatValue(value));
	}
	
	@Override
	public QLType getType() {
		return new QLFloat();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}

	
}
