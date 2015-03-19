package qls.ast.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import ql.ast.expression.Identifier;
import qls.gui.widget.InputWidget;

public class WidgetEnvironment {
	private Map<Identifier, InputWidget<?>> environment;
	
	public WidgetEnvironment() {
		environment = new HashMap<Identifier, InputWidget<?>>();
	}
	
	public void store(Identifier identifier, InputWidget<?> widgetInstance) {
		environment.put(identifier, widgetInstance);
	}
	
	public InputWidget<?> resolve(Identifier identifier) {		
		return environment.get(identifier);
	}
	
	// TODO Remove. It's just for testing.
	public Set<Identifier> getIdentifiers() {
		return environment.keySet();
	}
}
