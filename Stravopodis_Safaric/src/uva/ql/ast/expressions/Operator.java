package uva.ql.ast.expressions;

public enum Operator{
	ADD("+"),
	DIV("/"),
	EXP("^"),
	MUL("*"),
	SUB("-"),
	LESS("<"),
	LESS_EQ("<="),
	GREATER(">"),
	GREATER_EQ(">="),
	AND("&&"),
	OR("||"),
	EQUAL("=="),
	NOT_EQUAL("!=");
	
	private String name;
	
	private Operator(String _name){
		this.name = _name;
	}
	public String getName(){
		return this.name;
	}
	public static Operator findOperator(String operator){
		for(Operator o : Operator.values())
			if (o.getName().equals(operator))
				return o;
		return null;
	}
}


