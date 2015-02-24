package org.uva.sea.ql.AST.expression;

public enum Operator {
	AND("&&"),
	OR("||"),
	EQUAL_COND("=="),
	GREATER(">"),
	GREAT_EQUAL(">="),
	LESS_EQUAL("<="),
	LESS("<"),
	PLUS("+"),
	MINUS("-"),
	MULTIPLY("*"),
	DIVIDE("/");
	
	private final String operatorString;
	
	private Operator(String operatorString) {
		this.operatorString = operatorString;
	}

	public String getOperatorString() {
		return operatorString;
	}
	
	// See QLFactory for making objects from Operator. 
}
