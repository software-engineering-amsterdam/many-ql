package cons;

import java.util.HashMap;
import java.util.Map;

import cons.ql.ast.expression.Identifier;

@SuppressWarnings("rawtypes")
public class ValueEnvironment {
	private Map<String, Value> environment = new HashMap<String, Value>();
	
	public ValueEnvironment() {}
	
	public void store(Identifier identifier, Value valueInstance) {
		environment.put(identifier.toString(), valueInstance);
	}
	
	public Value resolve(Identifier identifier) {
		return environment.get(identifier.toString());
	}
	
	public Map<String, Value> getBindings() {
		return this.environment;
	}
	
	public void clear() {
		this.environment.clear();
	}
}
