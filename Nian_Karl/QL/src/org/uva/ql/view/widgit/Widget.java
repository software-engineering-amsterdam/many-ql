package org.uva.ql.view.widgit;

import javax.swing.JComponent;

public abstract class Widget {

	private String identifier;

	public abstract <T> T getValue();

	public abstract JComponent getWidget();

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
