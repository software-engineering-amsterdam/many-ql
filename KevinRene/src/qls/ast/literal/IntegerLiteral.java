package qls.ast.literal;

import qls.ast.Literal;
import qls.ast.QLSType;
import qls.ast.type.QLSInteger;
import qls.ast.visitor.Visitor;

public class IntegerLiteral extends Literal<Integer> {	
	public IntegerLiteral(int value) {
		super(value);
	}
	
	@Override
	public QLSType getType() {
		return new QLSInteger();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
