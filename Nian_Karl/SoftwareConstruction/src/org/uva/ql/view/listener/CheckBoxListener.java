package org.uva.ql.view.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.BoolValue;
import org.uva.ql.view.widget.CheckBox;

public class CheckBoxListener implements ItemListener {

	private final WidgetListener widgetListener;
	private final Identifier identifier;
	private final CheckBox checkBox;

	public CheckBoxListener(WidgetListener widgetListener, Identifier identifier, CheckBox checkbox) {
		super();
		this.checkBox = checkbox;
		this.widgetListener = widgetListener;
		this.identifier = identifier;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println("Setting checkbox");
		if (checkBox.getWidget().isSelected()) {
			widgetListener.widgetValueChanged(identifier, new BoolValue(checkBox.getValue()));
		} else {
			widgetListener.widgetValueChanged(identifier, new BoolValue(checkBox.getValue()));
		}
	}
}
