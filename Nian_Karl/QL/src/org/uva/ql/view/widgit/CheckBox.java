package org.uva.ql.view.widgit;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import org.uva.ql.ast.value.Bool;
import org.uva.ql.view.listener.WidgetListener;
import org.uva.ql.view.observer.Observer;

public class CheckBox extends Widget {

	private JCheckBox checkBox;
	private static final long serialVersionUID = 1L;
	private WidgetListener widgetListener;

	public CheckBox(WidgetListener listener) {
		checkBox = new JCheckBox();
		this.widgetListener = listener;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		checkBox.setOpaque(false);
		checkBox.addItemListener(checkboxListener);
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
	public JComponent getWidget() {
		return checkBox;
	}

}
