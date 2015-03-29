package ql.ast.visitor.evaluator;

import java.util.HashMap;
import java.util.Map;

import ql.Value;
import ql.ast.expression.Identifier;

public class ValueEnvironment {
	private Map<Identifier, Value> environment;
	
	public ValueEnvironment() {
		environment = new HashMap<Identifier, Value>();
	}
	
	public void store(Identifier identifier, Value valueInstance) {
		environment.put(identifier, valueInstance);
	}
	
	public Value resolve(Identifier identifier) {
		return environment.get(identifier);
	}
}
