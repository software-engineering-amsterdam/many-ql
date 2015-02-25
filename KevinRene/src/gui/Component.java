package gui;

import java.util.Observable;

import cons.Value;
import cons.ql.ast.expression.Identifier;

public abstract class Component extends Observable {

	protected final Identifier identifier;
	protected final Controller controller;
	
	public Component(Identifier identifier, Controller controller) {
		this.identifier = identifier;
		this.controller = controller;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public Value getValue() {
		return controller.resolveValue(identifier);
	}
	
	public Controller getController() {
		return this.controller;
	}
	
	public abstract void setValue(Value value);
	
}
