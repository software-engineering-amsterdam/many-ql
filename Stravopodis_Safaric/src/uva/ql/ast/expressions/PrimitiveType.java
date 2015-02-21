package uva.ql.ast.expressions;

public enum PrimitiveType {
	BOOLEAN("boolean"),
	INT("int"),
	STRING("string"),
	DECIMAL("decimal");
	
	private String name;
	
	private PrimitiveType(String _name){
		this.name = _name;
	}
	public String getName(){
		return this.name;
	}
	
	public static PrimitiveType findOperator(String operator){
		for(PrimitiveType type : PrimitiveType.values())
			if (type.getName().equals(operator))
				return type;
		return null;
	}
}
