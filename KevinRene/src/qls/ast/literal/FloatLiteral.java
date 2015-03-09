package qls.ast.literal;

import qls.ast.Literal;
import qls.ast.QLSType;
import qls.ast.type.QLSFloat;
import qls.ast.visitor.Visitor;


public class FloatLiteral extends Literal<Float> {	
	public FloatLiteral(float value) {
		super(value);
	}
	
	@Override
	public QLSType getType() {
		return new QLSFloat();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
