package nl.uva.se.ast.expression;

import nl.uva.se.constant.LogicalOperator;

public class Logical extends Binary {

	private final LogicalOperator operator;
	
	public Logical(Expression left, Expression right, LogicalOperator operator) {
		super(left, right);
		this.operator = operator;
	}

	public LogicalOperator getOperator() {
		return operator;
	}
	
}
