package org.uva.ql.view.widgit;

import javax.swing.JComponent;

import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.type.Type;
import org.uva.ql.ast.value.Value;

public abstract class Widget {

	protected Identifier identifier;

	public abstract <T> T getValue();

	public abstract JComponent getWidget();

	public abstract void setWidgetValue(Value value, Type type);

	public Identifier getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Identifier identifier) {
		this.identifier = identifier;
	}
}
