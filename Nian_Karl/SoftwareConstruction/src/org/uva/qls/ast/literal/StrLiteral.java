package org.uva.qls.ast.literal;

import org.uva.ql.ast.value.StrValue;
import org.uva.ql.ast.value.Value;
import org.uva.qls.ast.type.StrType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.visitor.LiteralVisitor;
import org.uva.utility.CodePosition;

public class StrLiteral extends Literal {

	private final String text;
	
	public StrLiteral(String text, CodePosition position) {
		super(position);
		this.text = text;
	}
	
	@Override
	public Value getValue() {
		return new StrValue(text); 
	}
	
	

	
	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Type getType() {
		return new StrType();
	}

}
