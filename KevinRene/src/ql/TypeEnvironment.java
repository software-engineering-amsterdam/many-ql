package ql;

import java.util.HashMap;
import java.util.Map;

import ql.ast.expression.Identifier;
import ql.ast.expression.QLType;

public class TypeEnvironment {
	private Map<String, QLType> environment = new HashMap<String, QLType>();
	
	public TypeEnvironment() { }
	
	public void store(Identifier identifier, QLType typeInstance) {
		environment.put(identifier.toString(), typeInstance);
	}
	
	public QLType resolve(Identifier identifier) {
		return environment.get(identifier.toString());
	}
	
	public Map<String, QLType> getBindings() {
		return this.environment;
	}
	
	public void clear() {
		this.environment.clear();
	}
}
