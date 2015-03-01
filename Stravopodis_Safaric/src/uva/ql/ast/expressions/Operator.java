package uva.ql.ast.expressions;

public enum Operator{
	ADD("+", "ADD"),
	DIV("/", "DIV"),
	EXP("^", "EXP"),
	MUL("*" , "MUL"),
	SUB("-", "SUB"),
	LESS("<", "LESS"),
	LESS_EQ("<=", "LESS_EQ"),
	GREATER(">", "GREATER"),
	GREATER_EQ(">=" , "GREATER_EQ"),
	AND("&&", "AND"),
	OR("||" , "OR"),
	EQUAL("==", "EQUAL"),
	NOT_EQUAL("!=", "NOT_EQUAL");
	
	private String name;
	private String alternativeName;
	
	private Operator(String _name){
		this.name = _name;
	}
	
	private Operator(String _name, String _alternativeName){
		this.name = _name;
		this.alternativeName = _alternativeName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAlternativeName(){
		return this.alternativeName;
	}
	
	public static Operator findOperator(String operator){
		for(Operator o : Operator.values())
			if (o.getName().equals(operator))
				return o;
		return null;
	}
}


