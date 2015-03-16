package org.uva.ql.view.widgit;

import javax.swing.JComponent;

import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.Value;

public abstract class Widget {

	protected String identifier;

	public abstract <T> T getValue();

	public abstract JComponent getWidget();

	public abstract void setWidgetValue(Value value, Type type);

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
