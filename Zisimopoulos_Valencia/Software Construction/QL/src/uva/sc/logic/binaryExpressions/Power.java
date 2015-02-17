package uva.sc.logic.binaryExpressions;

import uva.sc.logic.Expression;
import uva.sc.logic.Node;

public class Power extends Expression{
	
	Node base;
	Node exponent;
	
	public Power (Node base, Node exp) {
		this.base = base;
		this.exponent = exp;
	}

}
