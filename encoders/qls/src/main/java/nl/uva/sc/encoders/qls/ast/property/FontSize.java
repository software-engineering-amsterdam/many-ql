package nl.uva.sc.encoders.qls.ast.property;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class FontSize extends DefaultStyleProperty {

	private final int value;

	public FontSize(TextLocation textLocation, int value) {
		super(textLocation);
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}