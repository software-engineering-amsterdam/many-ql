package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class DefaultStyle extends AstNode {

	private final String datatype;
	private final String widget;
	private List<DefaultStyleProperty> defaultStyleProperties = new ArrayList<>();

	public DefaultStyle(TextLocation textLocation, String datatype, String widget) {
		super(textLocation);
		this.datatype = datatype;
		this.widget = widget;
	}

	public String getWidget() {
		return widget;
	}

	public String getDataType() {
		return datatype;
	}

	public void addDefaultStyleProperty(DefaultStyleProperty defaultStyleProperty) {
		defaultStyleProperties.add(defaultStyleProperty);
	}

	public List<DefaultStyleProperty> getDefaultStyleProperties() {
		return defaultStyleProperties;
	}
}
