package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cons.ql.ast.expression.Identifier;

public class Controller {
	
	private final Map<Identifier, Observable> observables;
	
	public Controller() {
		this.observables = new HashMap<Identifier, Observable>();
	}
	
	public void notify(Identifier identifier) {
		System.out.println(identifier + " has changed");
		Observable obs = observables.get(identifier);
		
		if (obs != null) {
			obs.notifyObservers();
		}
	}
	
	public void addObserver(Identifier x, Observer obs) {
		observables.get(x).addObserver(obs);
	}
	
	public void addGlobalObserver(Observer obs) {
		for(Identifier id : observables.keySet()) {
			addObserver(id, obs);
		}
	}
	
	public void putObservable(Identifier x, Observable obs) {
		observables.put(x, obs);
	}
}
