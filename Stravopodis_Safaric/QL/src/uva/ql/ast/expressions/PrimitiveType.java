package uva.ql.ast.expressions;

import uva.ql.ast.expressions.literals.*;

public enum PrimitiveType {
	BOOLEAN("boolean"),
	INT("integer"),
	STRING("string"),
	MONEY("money");
	
	private String name;
	
	private PrimitiveType(String _name){
		this.name = _name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public static PrimitiveType findOperator(String operator){
		for(PrimitiveType type : PrimitiveType.values())
			if (operator.equals(type.getName()))
				return type;
		return null;
	}
	
	public static Expression identifierFromPrimitiveType(String primitiveType, Object value){
		PrimitiveType type = PrimitiveType.findOperator(primitiveType);
		
		switch(type){
			case BOOLEAN: 	return new BooleanLiteral(((BooleanLiteral)value).evaluate().getValue(), null);
			case INT: 		return (IntLiteral)value;
			case MONEY:		return (MoneyLiteral)value;
			case STRING: 	return new StringLiteral(String.valueOf(value), null);
		}
		return null;
	}
	
	public static String classNameFromPrimitiveType(PrimitiveType primitiveType){
		
		switch(primitiveType){
			case BOOLEAN	: return BooleanLiteral.class.getSimpleName();
			case INT		: return IntLiteral.class.getSimpleName();
			case MONEY		: return MoneyLiteral.class.getSimpleName();
			case STRING		: return StringLiteral.class.getSimpleName();
		}
		return null;
	}
}
