package qls.ast.literal;

import qls.ast.Literal;
import qls.ast.QLSType;
import qls.ast.type.QLSString;
import qls.ast.visitor.Visitor;

public class StringLiteral extends Literal<String> {	
	public StringLiteral(String value) {
		super(value);
	}
	
	@Override
	public QLSType getType() {
		return new QLSString();
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
}
