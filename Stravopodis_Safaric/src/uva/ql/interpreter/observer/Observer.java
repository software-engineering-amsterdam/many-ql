package uva.ql.interpreter.observer;


public abstract class Observer {
	protected Subject subject;
	
	public abstract void update();
}
