package com.form.language.gui.widget;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import com.form.language.ast.values.BoolValue;

public class CheckBox extends JCheckBox implements Widget {
	private static final long serialVersionUID = 1L;
	private WidgetListener widgetListener;
	
	public CheckBox(WidgetListener listener) {
		this.widgetListener = listener;
		CheckBoxListener checkboxListener = new CheckBoxListener();
		addItemListener((ItemListener) checkboxListener);
	}
	
	private class CheckBoxListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == CheckBox.this) {
				if (CheckBox.this.isSelected()) {
					widgetListener.widgetValueChanged(getIdentifier(), new BoolValue(getValue()));
				} else {
					widgetListener.widgetValueChanged(getIdentifier(), new BoolValue(getValue()));
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Boolean getValue() {
		return isSelected();
	}

	@Override
	public JComponent getWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdentifier(String identifier) {
		// TODO Auto-generated method stub
		
	}
}
