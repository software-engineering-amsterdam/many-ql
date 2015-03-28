package org.uva.ql.view.widgit;

import java.awt.Component;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.value.Value;

public abstract class Widget {

	protected Identifier identifier;

	public abstract <T> T getValue();

	public abstract Component getWidget();

	public abstract void setWidgetValue(Value value);

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}
}
