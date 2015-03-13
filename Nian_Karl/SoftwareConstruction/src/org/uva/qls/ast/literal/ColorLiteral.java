package org.uva.qls.ast.literal;

import java.awt.Color;

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

	public ColorLiteral(Color color, CodePosition pos) {
		super(pos);
		this.value = new ColorValue(color);
	}
	
	public ColorLiteral(int r, int g, int b, CodePosition pos) {
		super(pos);
		Color color = new Color(r, g, b);
		this.value = new ColorValue(color);
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
