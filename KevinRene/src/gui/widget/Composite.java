package gui.widget;

import gui.Widget;
import cons.ql.ast.expression.Identifier;

public abstract class Composite extends Widget {
	private final Identifier identifier;
	
	public Composite(Identifier identifier) {
		this.identifier = identifier;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}	
}
