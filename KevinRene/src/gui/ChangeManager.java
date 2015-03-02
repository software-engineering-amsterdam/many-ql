package gui;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cons.ValueEnvironment;

public class ChangeManager {	
	private final Map<Observable, Observer> observerMapping;
	
	public ChangeManager(ValueEnvironment valueEnv) {
		this.observerMapping = new HashMap<Observable, Observer>();
	}
	
	public void register(Observable observable, Observer observer) {
		observerMapping.put(observable, observer);
	}
	
	// Listens to every identifier
	public void unregister(Observable observable) {
		observerMapping.remove(observable);
	}
	
	public void notifyObservers() {
		for(Observable observable : observerMapping.keySet()) {
			observable.notify();
		}
	}
}
