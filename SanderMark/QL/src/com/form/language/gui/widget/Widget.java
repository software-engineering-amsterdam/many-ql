package com.form.language.gui.widget;

import javax.swing.JComponent;

public interface Widget {
	public <T> T getValue();
	public abstract JComponent getWidget();
	public String getIdentifier();
	public void setIdentifier(String identifier);
}
