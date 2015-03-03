package gui.widget;

import gui.Widget;
import cons.Value;
import cons.ql.ast.expression.Identifier;

public abstract class Composite implements Widget {
	private final Identifier identifier;
	private Widget handler;
	
	public Composite(Identifier identifier) {
		this.identifier = identifier;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	@Override
	public void setHandler(Widget handler) {
		this.handler = handler;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue) {
		handler.handleChange(changedValue);
	}
}
