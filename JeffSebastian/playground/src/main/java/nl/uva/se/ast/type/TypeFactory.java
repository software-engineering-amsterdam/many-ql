package nl.uva.se.ast.type;

public class TypeFactory {
	
	private TypeFactory() {
	}
	
	public static Type getTypeForName(String typeName) {
		if (typeName.equalsIgnoreCase("boolean")) {
			return new BooleanType();
		} else if (typeName.equalsIgnoreCase("integer")) {
			return new IntegerType();
		} else if (typeName.equalsIgnoreCase("decimal")) {
			return new DecimalType();
		} else if (typeName.equalsIgnoreCase("string")) {
			return new StringType();
		}
		
		return new UndefinedType();
	}

}
