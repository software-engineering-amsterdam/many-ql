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
		System.out.println("ID: " + identifier + ", value: " + environment.get(identifier.toString()));
		return environment.get(identifier.toString());
	}
	
	public Map<String, Value> getBindings() {
		return this.environment;
	}
}
