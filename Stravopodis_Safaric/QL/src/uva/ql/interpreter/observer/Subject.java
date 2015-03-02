package uva.ql.interpreter.observer;


public class Subject {
	
	private Observer observer;
	public String lastResponse;
	
	public void setObserver(Observer _observer){
		this.observer = _observer;
	}
	
	public void notifyObserver(){
		this.observer.update();
	}
	
}
