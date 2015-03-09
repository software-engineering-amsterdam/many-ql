package org.uva.ql.view.widgit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.ql.ast.type.UndefinedType;
import org.uva.ql.ast.value.Bool;
import org.uva.ql.ast.value.Undefined;
import org.uva.ql.ast.value.Value;
import org.uva.ql.view.listener.WidgetListener;

public class CheckBox extends Widget {

	private JCheckBox checkBox;
	private WidgetListener widgetListener;

	public CheckBox(WidgetListener listener) {
		super();
		checkBox = new JCheckBox();
		this.widgetListener = listener;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		checkBox.setOpaque(false);
		if (!isDependent()) {
			checkBox.addItemListener(checkboxListener);
		}

	}

	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == CheckBox.this.checkBox) {
				if (CheckBox.this.checkBox.isSelected()) {
					widgetListener.widgetValueChanged(getIdentifier(), new Bool(getValue()));
				} else {
					widgetListener.widgetValueChanged(getIdentifier(), new Bool(getValue()));
				}
			}
		}
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
	public void setWidgetValue(Value value) {
		if (!value.getType().isEqual(new UndefinedType()) && isDependent()) {
			if (value.getType().isBool()) {
				Bool booleanValue = (Bool) value;
				if (booleanValue.getValue()) {
					checkBox.setSelected(true);
				}
			}
		} else if (isDependent()) {
			checkBox.setSelected(false);
		}
	}

}
