package org.uva.qls.ast.literal;

import org.uva.qls.visitor.LiteralVisitor;
import org.uva.utility.CodePosition;

public class StrLiteral extends Literal {

	private final String text;
	
	public StrLiteral(String text, CodePosition position) {
		super(position);
		this.text = text;
	}
	
	public String getValue() {
		return text; 
	}

	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

}
