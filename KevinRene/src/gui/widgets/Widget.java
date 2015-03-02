package gui.widgets;

import gui.Controller;

import java.util.Observable;

import javax.swing.JComponent;

import cons.Value;
import cons.ql.ast.expression.Identifier;

public abstract class Widget extends Observable {

	protected final Identifier identifier;
	protected final Controller controller;
	
	public Widget(Identifier identifier, Controller controller) {
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
	public abstract JComponent getComponent();
}
