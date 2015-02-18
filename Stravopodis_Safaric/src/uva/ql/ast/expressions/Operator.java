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
	NOT_EQUAL("!");
	
	private String name;
	
	private Operator(String _name){
		this.name = _name;
	}
	public String getName(){
		return this.name;
	}
	public static Operator findOperator(String operator){
		
		for(Operator o : Operator.values()){
			System.out.println("Comparing " + o.getName() + " and " + operator);
			if (o.getName().equals(operator)){
				System.err.println("Found operator: " + o);
				return o;
			}
		}
		System.err.println("Did not found operator");
		return null;
	}
}

