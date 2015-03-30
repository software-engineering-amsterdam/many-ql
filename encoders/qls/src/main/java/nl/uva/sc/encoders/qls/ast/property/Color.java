package nl.uva.sc.encoders.qls.ast.property;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.visitor.DefaultPropertyVisitor;

public class Color extends DefaultStyleProperty {

	private final String value;

	public Color(TextLocation textLocation, String value) {
		super(textLocation);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public <T> T accept(DefaultPropertyVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
