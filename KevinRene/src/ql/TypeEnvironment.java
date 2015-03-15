package ql;

import java.util.HashMap;
import java.util.Map;

import ql.ast.QLType;
import ql.ast.expression.Identifier;

public class TypeEnvironment {
	private Map<String, QLType> environment = new HashMap<String, QLType>();
	private TypeEnvironment parentEnvironment;
	
	public TypeEnvironment(TypeEnvironment parent) { 
		this.parentEnvironment = parent;
	}
	public TypeEnvironment() { }
	
	public void store(Identifier identifier, QLType typeInstance) {
		environment.put(identifier.toString(), typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		QLType type = environment.get(identifier.toString());
		if (type == null && parentEnvironment != null) {
			type = parentEnvironment.resolve(identifier);
		}
		return type;
	}
	
	public TypeEnvironment getParent() {
		return (parentEnvironment == null ) ? this : parentEnvironment;
	}
	
	
}