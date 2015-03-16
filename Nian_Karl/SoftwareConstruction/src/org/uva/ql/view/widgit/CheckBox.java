package org.uva.ql.view.widgit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.BoolValue;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.WidgetListener;

public class CheckBox extends Widget implements ItemListener {

	private JCheckBox checkBox;
	private WidgetListener widgetListener;

	public CheckBox(WidgetListener listener) {
		super();
		checkBox = new JCheckBox();
		this.widgetListener = listener;
		checkBox.setOpaque(false);
		checkBox.addItemListener(this);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean getValue() {
		return checkBox.isSelected();
	}

	@Override
	public JCheckBox getWidget() {
		return checkBox;
	}

	@Override
	public void setWidgetValue(Value value, Type type) {
		if (!type.isEqual(new UndefinedType())) {
			if (type.isBool() && !value.isUndefined()) {
				BoolValue booleanValue = (BoolValue) value;
				if (booleanValue.value()) {
					checkBox.setSelected(true);
				} else {
					checkBox.setSelected(false);
				}
			} else {
				checkBox.setSelected(false);
			}
		} else {
			checkBox.setSelected(false);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == CheckBox.this.checkBox) {
			if (CheckBox.this.checkBox.isSelected()) {
				widgetListener.widgetValueChanged(getIdentifier(), new BoolValue(getValue()));
			} else {
				widgetListener.widgetValueChanged(getIdentifier(), new BoolValue(getValue()));
			}
		}
	}
}
