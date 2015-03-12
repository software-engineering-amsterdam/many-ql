package uva.ql.interpreter.observer;

import uva.ql.interpreter.typecheck.table.ExpressionTable;

public class Subject {
	
	private Observer observer;
	public String lastResponse;
	
	public void setObserver(Observer _observer){
		this.observer = _observer;
	}
	
	public void notifyObserver(){
		this.observer.update();
	}
	
	public void notifyObserver(ExpressionTable _expressionTable){
		this.observer._expressionTable = _expressionTable;
		this.observer.update();
	}
	
	public ExpressionTable getExpressionTable(){
		return this.observer._expressionTable;
	}
}
