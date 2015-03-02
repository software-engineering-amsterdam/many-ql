package gui.widgets;

import java.util.Observable;

import javax.swing.JComponent;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;

public abstract class Widget extends Observable {

	protected final Identifier identifier;
	protected final ValueEnvironment valueEnv;
	
	public Widget(Identifier identifier, ValueEnvironment valueEnv) {
		this.identifier = identifier;
		this.valueEnv = valueEnv;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public Value getValue() {
		return valueEnv.resolve(identifier);
	}
	
	
	public abstract void setValue(Value value);
	public abstract JComponent getComponent();
}
