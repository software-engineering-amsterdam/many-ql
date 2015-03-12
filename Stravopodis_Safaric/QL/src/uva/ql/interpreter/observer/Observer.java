package uva.ql.interpreter.observer;

import uva.ql.interpreter.typecheck.table.ExpressionTable;


public abstract class Observer {
	
	protected Subject subject;
	public ExpressionTable _expressionTable;
	public abstract void update();

}
