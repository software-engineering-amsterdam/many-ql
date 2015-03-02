package gui;

import gui.widgets.Widget;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;

public class Controller {
	
	private final Map<Identifier, Widget> components;
	private final ValueEnvironment valueEnv;
	
	public Controller(ValueEnvironment valueEnv) {
		this.components = new HashMap<Identifier, Widget>();
		this.valueEnv = valueEnv;
	}
	
	/**
	 * Call this method when the input of a question has changed.
	 * The supplied identifier is used to retrieve the Component
	 * that supplies the identifier for this value. The method
	 * then notifies the observers of this Component.
	 */
	public void notify(Identifier identifier) {
		Widget comp = components.get(identifier);
		
		if (comp != null) {
			comp.notifyObservers();
		}
	}
	
	public void addComponent(Identifier x, Observer obs) {
		components.get(x).addObserver(obs);
	}
	
	// Listens to every identifier
	public void addGlobalObserver(Observer obs) {
		for(Identifier id : components.keySet()) {
			addComponent(id, obs);
		}
	}
	
	public void putComponent(Identifier x, Widget obs) {
		components.put(x, obs);
	}
	
	// Access point for the TypeEnvironment
	public void storeValue(Identifier x, Value value) {
		valueEnv.store(x, value);
	}
	
	public Value resolveValue(Identifier identifier) {
		return valueEnv.resolve(identifier);
	}
	
	
	public ValueEnvironment getValueEnvironment() {
		return this.valueEnv;
	}
}
