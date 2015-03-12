package org.uva.qls.ast.literal;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.type.IdentifierType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.StrValue;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitor;

public class IdentifierLiteral extends Literal {

	private final StrValue value;
	
	public IdentifierLiteral(StrValue value, CodePosition pos) {
		super(pos);
		this.value = value;
	}

	@Override
	public <T> T accept(LiteralVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value getValue() {
		return value;
	}

	
	@Override
	public Type getType() {
		return new IdentifierType(this.getPosition());
	}
	
	@Override
	public String toString() {
		return super.toString() + "<" + value.toString() + ">";
	}

}
