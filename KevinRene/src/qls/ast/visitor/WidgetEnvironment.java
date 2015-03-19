package qls.ast.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ql.ast.expression.Identifier;
import ql.gui.UIComponent;

public class WidgetEnvironment {
	private Map<Identifier, UIComponent> environment;
	
	public WidgetEnvironment() {
		environment = new HashMap<Identifier, UIComponent>();
	}
	
	public void store(Identifier identifier, UIComponent widgetInstance) {
		environment.put(identifier, widgetInstance);
	}
	
	public UIComponent resolve(Identifier identifier) {		
		return environment.get(identifier);
	}
	
	// TODO Remove. It's just for testing.
	public Set<Identifier> getIdentifiers() {
		return environment.keySet();
	}
}
