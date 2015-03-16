package evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValueRepository {
	private final Map<String, Value> valueRepository; 
	
	public ValueRepository() {
		this.valueRepository = new HashMap<String, Value>();
	}
	
	public void putValue(String id, Value value) {
		valueRepository.put(id, value);
	}
	
	public boolean isDeclared(String id) {
		return valueRepository.containsKey(id);
	}
	
	public Value getValue(String id) {
		if(isDeclared(id)) {
			return valueRepository.get(id);
		}
		return null;
	}
	
	public Set<String> getIDkeys() {
		Set<String> keys = valueRepository.keySet();
		return keys;
	}
}
