package interpreter;

import java.util.HashMap;

import ast.expression.variables.Id;

public class ValueRepository {
	private final HashMap<Id, Value> valueStorage = new HashMap<Id, Value>(); 
	
	public void putVariables(Id id, Value value) {
		valueStorage.put(id, value);
	}
	
	public HashMap<Id, Value> getValueStorage() {
		return valueStorage;
	}
	
	// Returns true if this map maps one or more keys to the specified value.
	public Boolean declared(Id id) {
		return valueStorage.containsKey(id);
	}
	
	public Value getVariables(Id id) {
		return valueStorage.get(id);
	}
}
