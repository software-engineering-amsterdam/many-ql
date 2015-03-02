package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cons.ValueEnvironment;
import cons.ql.ast.expression.Identifier;

public class ChangeManager {	
	private final Map<Observable, Observer> observerMapping;
	private final ValueEnvironment valueEnv;
	
	public ChangeManager(ValueEnvironment valueEnv) {
		this.observerMapping = new HashMap<Observable, Observer>();
		this.valueEnv = valueEnv;
	}
	
	public void register(Observable observable, Observer observer) {
		observerMapping.put(observable, observer);
	}
	
	// Listens to every identifier
	public void unregister(Observable observable) {
		observerMapping.remove(observable);
	}
	
	public void notify(Identifier x, Widget obs) {
		for(Observable observable : observerMapping.keySet()) {
			observable.notify();
		}
	}
		
	public ValueEnvironment getValueEnvironment() {
		return this.valueEnv;
	}
}
