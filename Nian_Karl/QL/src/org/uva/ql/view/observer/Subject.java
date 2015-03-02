package org.uva.ql.view.observer;

public interface Subject {
	public void register(Observer observer);
	public void unregister(Observer observer);
	public void notifyObserver();
}
