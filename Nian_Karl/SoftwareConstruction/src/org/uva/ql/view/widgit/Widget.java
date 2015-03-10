package org.uva.ql.view.widgit;

import javax.swing.JComponent;

import org.uva.ql.ast.value.Value;

public abstract class Widget {

	private boolean dependent;
	
	private String identifier;

	public abstract <T> T getValue();

	public abstract JComponent getWidget();

	public abstract void setWidgetValue(Value value);
	
	public String getIdentifier() {
		return identifier;
	}

	public boolean isDependent() {
		return dependent;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setDependent(boolean dependent) {
		this.dependent = dependent;
	}
}
