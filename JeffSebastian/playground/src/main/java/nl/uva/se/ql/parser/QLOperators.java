package nl.uva.se.ql.parser;

public enum QLOperators {
	OR("||"),
	AND("&&"),
	EQUAL("=="),
	NOT_EQUAL("!="),
	GREATER_THAN(">"),
	LESS_THEN("<"),
	GREATER_OR_EQUAL(">="),
	LESS_OR_EQUAL("<="),
	NOT("!"),
	POWER("^"),
	MODULO("%"),
	DIVIDE("/"),
	MULTIPLY("*"),
	MINUS("-"),
	PLUS("+"),
	UNDEFINED("undefined");
	
	private String name;
	
	private QLOperators(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static QLOperators getByName(String name) {
		for (QLOperators operator : QLOperators.values()) {
			if (operator.getName().equals(name)) {
				return operator;
			}
		}
		
		return UNDEFINED;
	}
}
