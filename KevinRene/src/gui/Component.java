package gui;

import java.util.Observable;

import cons.ql.ast.expression.Identifier;

public class Component extends Observable {

	// The identifier is required to find the value of
	// this component (for the evaluator)
	private final Identifier identifier;
	private final Controller controller;
	
	public Component(Identifier identifier, Controller controller) {
		this.identifier = identifier;
		this.controller = controller;
	}
	
	public Identifier getIdentifier() {
		return this.identifier;
	}
	
	public Controller getController() {
		return this.controller;
	}
	
}
