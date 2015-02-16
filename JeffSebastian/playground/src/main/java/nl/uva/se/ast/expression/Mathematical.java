package nl.uva.se.ast.expression;

import nl.uva.se.constant.MathematicalOperator;

public class Mathematical extends Binary {

	private final MathematicalOperator operator;
	
	public Mathematical(Expression left, Expression right, MathematicalOperator operator) {
		super(left, right);
		this.operator = operator;
	}

	public MathematicalOperator getOperator() {
		return operator;
	}

}
