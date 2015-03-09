package uva.sc.gui;

import uva.sc.logic.Expression;

public class DisplayData {
	Expression value;
	Expression condition;
	
	public Expression getValue(){return value;}
	public Expression getCondition(){return condition;}
	
	public DisplayData(Expression v){
		value = v;
	}
	
	public DisplayData (Expression v, Expression c){
		value = v;
		condition = c;
	}
}
