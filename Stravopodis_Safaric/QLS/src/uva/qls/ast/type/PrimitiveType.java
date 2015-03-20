package uva.qls.ast.type;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> getAllTypes(){
		List<String> types = new ArrayList<String>();
		for (PrimitiveType type : values()){
			types.add(type.getName());
		}
		return types;
	}
	
	public static PrimitiveType findOperator(String operator){
		for (PrimitiveType type: PrimitiveType.values())
			if (operator.equals(type.getName()))
				return type;
		return null;
		
	}
}
