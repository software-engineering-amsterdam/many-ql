package org.uva.qls.ast.literal;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.type.ColorType;
import org.uva.qls.ast.type.Type;
import org.uva.qls.ast.value.ColorValue;
import org.uva.qls.ast.value.Value;
import org.uva.qls.visitor.LiteralVisitor;

public class ColorLiteral extends Literal {

	private final ColorValue value;
	
	public ColorLiteral(ColorValue value, CodePosition pos) {
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
		return new ColorType(this.getPosition());
	}
	
	@Override
	public String toString() {
		return super.toString() + "<" + value.toString() + ">";
	}

}
