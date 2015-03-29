package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class DefaultStyle extends AstNode {

	private final String datatype;
	private final Widget widget;
	private List<DefaultStyleProperty> defaultStyleProperties = new ArrayList<>();

	public DefaultStyle(TextLocation textLocation, String datatype, Widget widget) {
		super(textLocation);
		this.datatype = datatype;
		this.widget = widget;
	}

	public String getDefaultStyleDataType() {
		return datatype;
	}

	public Widget getDefaultStyleWidget() {
		return widget;
	}

	public void addDefaultStyleProperty(DefaultStyleProperty defaultStyleProperty) {
		defaultStyleProperties.add(defaultStyleProperty);
	}

	public List<DefaultStyleProperty> getDefaultStyleProperties() {
		return defaultStyleProperties;
	}

}
