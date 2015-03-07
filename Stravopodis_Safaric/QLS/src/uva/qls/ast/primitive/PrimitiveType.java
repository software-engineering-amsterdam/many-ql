package uva.qls.ast.primitive;

public enum PrimitiveType {

	BOOLEAN("boolean"),
	INT("integer"),
	STRING("string"),
	MONEY("money");
	
	private String name;
	
	private PrimitiveType(String _name){
		this.name=_name;
	}
	public String getName(){
		return this.name;
	}
	
	public static PrimitiveType findOperator(String operator){
		for (PrimitiveType type: PrimitiveType.values())
			if (operator.equals(type.getName()))
				return type;
		return null;
		
	}
}
