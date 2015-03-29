package nl.uva.sc.encoders.qls.ast.property;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Font extends DefaultStyleProperty {

	private final String value;

	public Font(TextLocation textLocation, String value) {
		super(textLocation);
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
