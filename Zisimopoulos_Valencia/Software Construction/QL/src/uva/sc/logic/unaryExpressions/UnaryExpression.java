package uva.sc.logic.unaryExpressions;

import uva.sc.logic.Expression;
import uva.sc.logic.Node;

public abstract class UnaryExpression extends Expression{
	
	Node operand;
	
	public UnaryExpression (Node operand){
		this.operand = operand;
	}
}
