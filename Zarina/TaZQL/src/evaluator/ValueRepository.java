package evaluator;

import java.util.HashMap;
import java.util.Set;

public class ValueRepository {
	private final HashMap<String, Value> valueRepository; 
	
	public ValueRepository() {
		this.valueRepository = new HashMap<String, Value>();
	}
	
	public void putID(String id, Value value) {
		valueRepository.put(id, value);
	}
	
	public HashMap<String, Value> getValueRepository() {
		System.out.println("Rep"+ valueRepository.toString());
		return valueRepository;
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
