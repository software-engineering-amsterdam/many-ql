package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class DefaultStyleProperty extends AstNode {

	private final String propertyName;
	private final String propertyValue;

	public DefaultStyleProperty(TextLocation textLocation, String propertyName, String propertyValue) {
		super(textLocation);
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getPropertyValues() {
		return propertyValue;
	}
}
