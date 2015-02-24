package interpreter;

import java.util.HashMap;

import ast.expression.variables.Id;

public class ValueRepository {
	private final HashMap<Id, Value> valueRepository = new HashMap<Id, Value>(); 
	
	public void putID(Id id, Value value) {
		valueRepository.put(id, value);
	}
	
	public HashMap<Id, Value> getValueRepository() {
		return valueRepository;
	}
	
	public boolean isDeclared(Id id) {
		return valueRepository.containsKey(id);
	}
	
	public Value getValue(Id id) {
		if(isDeclared(id)) {
			return valueRepository.get(id);
		}
		return null;
	}
}
