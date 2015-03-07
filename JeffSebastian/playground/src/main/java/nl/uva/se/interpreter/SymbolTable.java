package nl.uva.se.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.ast.type.Type;

public class SymbolTable {

	private Map<String, Type> symbols;
	
	public SymbolTable() {
		symbols = new HashMap<String, Type>();
	}
	
	public void addSymbol(String name, Type type) {
		symbols.put(name, type);
	}
	
	public boolean containsSymbol(String name) {
		return symbols.containsKey(name);
	}
	
	public Type getTypeForSymbol(String name) {
		return symbols.get(name);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Type> entry : symbols.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue().getTypeName());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
