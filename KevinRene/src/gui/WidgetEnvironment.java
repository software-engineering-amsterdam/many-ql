package gui;

import gui.widgets.Widget;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import cons.Value;
import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;

public class WidgetEnvironment {
	
	private final Map<Identifier, Widget> widgets;
	
	public WidgetEnvironment() {
		this.widgets = new HashMap<Identifier, Widget>();
	}
	
	public void addObserver(Identifier x, Observer obs) {
		widgets.get(x).addObserver(obs);
	}
	
	// Listens to every identifier
	public void addGlobalObserver(Observer obs) {
		for(Identifier id : widgets.keySet()) {
			addObserver(id, obs);
		}
	}
	
	public void putObservable(Identifier x, Widget obs) {
		widgets.put(x, obs);
	}
}
