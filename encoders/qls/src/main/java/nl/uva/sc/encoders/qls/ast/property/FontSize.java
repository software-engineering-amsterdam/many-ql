package nl.uva.sc.encoders.qls.ast.property;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.visitor.DefaultPropertyVisitor;

public class FontSize extends DefaultStyleProperty {

	private final int value;

	public FontSize(TextLocation textLocation, int value) {
		super(textLocation);
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	@Override
	public <T> T accept(DefaultPropertyVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
