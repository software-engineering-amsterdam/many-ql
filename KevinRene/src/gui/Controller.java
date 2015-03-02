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
		
	public ValueEnvironment getValueEnvironment() {
		return this.valueEnv;
	}
}
