package org.uva.qls.view.widget;

import java.awt.Component;

import javax.swing.JComponent;

import org.uva.ql.ast.Node;

public abstract class Widget<T extends Node> extends Component {

	private static final long serialVersionUID = -1896148695421639903L;
	private final T widgetModel;

	public Widget(T widgetModel) {
		this.widgetModel = widgetModel;
	}

	public T getWidgetModel() {
		return widgetModel;
	}

	public abstract JComponent getWidget();
}
