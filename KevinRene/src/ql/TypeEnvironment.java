package ql;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ql.ast.QLType;
import ql.ast.expression.Identifier;

public class TypeEnvironment {
	private Map<Identifier, QLType> environment = new HashMap<Identifier, QLType>();
	private TypeEnvironment parentEnvironment;
	
	public TypeEnvironment(TypeEnvironment parent) { 
		this.parentEnvironment = parent;
	}
	public TypeEnvironment() { }
	
	public void store(Identifier identifier, QLType typeInstance) {
		environment.put(identifier, typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		QLType type = environment.get(identifier);
		
		if (type == null && parentEnvironment != null) {
			type = parentEnvironment.resolve(identifier);
		}
		
		return type;
	}
	
	public Set<Identifier> getIdentifiers() {
		return environment.keySet();
	}
	
	public TypeEnvironment getParent() {
		return (parentEnvironment == null ) ? this : parentEnvironment;
	}
}
