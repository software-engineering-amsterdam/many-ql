package qls.ast.visitor.widgetbinder;

import java.util.HashMap;
import java.util.Map;

import ql.Value;
import ql.ast.expression.Identifier;

public class DefaultWidgetEnvironment {
	private Map<Identifier, Value> environment;
	private DefaultWidgetEnvironment parentEnvironment;
	
	public DefaultWidgetEnvironment() {
		environment = new HashMap<Identifier, Value>();
	}
	
	public DefaultWidgetEnvironment(DefaultWidgetEnvironment parent) {
		parentEnvironment = parent;
	}
	
	public void store(Identifier identifier, Value valueInstance) {
		environment.put(identifier, valueInstance);
	}
	
	public Value resolve(Identifier identifier) {
		return environment.get(identifier);
	}
	
	public DefaultWidgetEnvironment getParent() {
		if(parentEnvironment == null) {
			return this;
		}
		
		return parentEnvironment;
	}
}
