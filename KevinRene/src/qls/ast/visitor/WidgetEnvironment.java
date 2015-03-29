package qls.ast.visitor;

import java.util.HashMap;
import java.util.Map;

import ql.ast.expression.Identifier;
import ql.gui.Component;

public class WidgetEnvironment {
	private Map<Identifier, Component> environment;
	
	public WidgetEnvironment() {
		environment = new HashMap<Identifier, Component>();
	}
	
	public void store(Identifier identifier, Component widgetInstance) {
		environment.put(identifier, widgetInstance);
	}
	
	public Component resolve(Identifier identifier) {		
		return environment.get(identifier);
	}	
}