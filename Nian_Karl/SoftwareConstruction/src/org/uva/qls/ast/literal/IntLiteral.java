package org.uva.qls.ast.literal;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.type.IntType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.IntValue;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitor;

public class IntLiteral extends Literal{

	private final IntValue value;
	
	public IntLiteral(IntValue value,CodePosition pos) {
		super(pos);
		this.value = value;
	}

	public IntLiteral(int value,CodePosition pos) {
		super(pos);
		this.value = new IntValue(value);
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
		return new IntType(this.getPosition());
	}

	@Override
	public String toString() {
		return super.toString() + "<" + value.toString() + ">";
	}
	
}
