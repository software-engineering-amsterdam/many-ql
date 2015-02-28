package uva.ql.ast.expressions;


import uva.ql.ast.expressions.literals.*;

public enum PrimitiveType {
	BOOLEAN("boolean","Boolean", "boolean"),
	INT("int","Int", "integer"),
	STRING("string","String", "string"),
	DECIMAL("decimal","Float", "float");
	
	private String name1;
	private String name2;
	private String name3;
	
	private PrimitiveType(String _name){
		this.name1 = _name;
	}
	private PrimitiveType(String _name, String name2){
		this.name1 = _name;
		this.name2 = name2;
	}
	private PrimitiveType(String _name1, String _name2, String _name3){
		this(_name1, _name2);
		this.name3 = _name3;
	}
	public String getName(){
		return this.name1;
	}
	public String getName2(){
		return this.name2;
	}
	public String getName3(){
		return this.name3;
	}
	public static PrimitiveType findOperator(String operator){
		for(PrimitiveType type : PrimitiveType.values())
			if (operator.equals(type.getName()) || operator.equals(type.getName2()) || operator.equals(type.getName3()))
				return type;
		return null;
	}
	public static Expression identifierFromPrimitiveType(String primitiveType, Object value){
		
		PrimitiveType type = PrimitiveType.findOperator(primitiveType);
		
		switch(type){
			case BOOLEAN: 	return new BooleanLiteral(((BooleanLiteral)value).evaluate().getValue(), null);
			case INT: 		return (IntLiteral)value;
			case DECIMAL:	return new DecimalLiteral((float)value, null);
			case STRING: 	return new StringLiteral(String.valueOf(value), null);
		}
		return null;
	}
}
