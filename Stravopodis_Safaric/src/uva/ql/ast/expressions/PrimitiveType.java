package uva.ql.ast.expressions;

public enum PrimitiveType {
	BOOLEAN("boolean","Boolean"),
	INT("int","Int"),
	STRING("string","String"),
	DECIMAL("decimal","Float");
	
	private String name;
	private String nameAlternative;
	
	private PrimitiveType(String _name){
		this.name = _name;
	}
	private PrimitiveType(String _name, String _alternative){
		this.name = _name;
		this.nameAlternative = _alternative;
	}
	public String getName(){
		return this.name;
	}
	public String getAlternative(){
		return this.nameAlternative;
	}
	public static PrimitiveType findOperator(String operator){
		for(PrimitiveType type : PrimitiveType.values())
			if (type.getName().equals(operator))
				return type;
		return null;
	}
}
