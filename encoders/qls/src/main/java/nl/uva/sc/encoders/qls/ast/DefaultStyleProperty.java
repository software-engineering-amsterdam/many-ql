package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class DefaultStyleProperty extends AstNode {

	private final String defaultStyleProperty;

	public DefaultStyleProperty(TextLocation textLocation, String defaultStyleProperty) {
		super(textLocation);
		this.defaultStyleProperty = defaultStyleProperty;
	}

	public String getDefaultStyleProperty() {
		return defaultStyleProperty;
	}

}
