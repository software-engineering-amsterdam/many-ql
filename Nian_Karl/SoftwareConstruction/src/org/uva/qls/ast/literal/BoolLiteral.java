package org.uva.qls.ast.literal;

import org.uva.qls.ast.type.BoolType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.BoolValue;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitor;
import org.uva.utility.CodePosition;

public class BoolLiteral extends Literal {

	private final BoolValue value;
	
	public BoolLiteral(BoolValue value, CodePosition pos) {
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
		return new BoolType(this.getPosition());
	}

	@Override
	public String toString() {
		return super.toString() + "<" + value.toString() + ">";
	}

}
