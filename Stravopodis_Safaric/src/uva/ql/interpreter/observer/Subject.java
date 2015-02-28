package uva.ql.interpreter.observer;

public class Subject {
	
	private Observer observer;
	
	
	public void notifyObserver(){
		this.observer.update();
	}
	
}
