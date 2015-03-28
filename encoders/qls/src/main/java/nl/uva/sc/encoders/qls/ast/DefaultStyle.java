package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class DefaultStyle extends AstNode {

	private final String datatype;
	private List<DefaultStyleProperty> defaultStyleProperties = new ArrayList<>();
	private Widget widget;

	public DefaultStyle(TextLocation textLocation, String datatype) {
		super(textLocation);
		this.datatype = datatype;
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

	public void setDefaultStyleWidget(Widget widget) {
		this.widget = widget;
	}

	public Widget getDefaultStyleWidget() {
		return widget;
	}
}
