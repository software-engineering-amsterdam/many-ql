package nl.uva.se.interpreter;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import nl.uva.se.constant.Type;

public class SymbolTable {

	private Map<String, Type> symbols;
	
	public SymbolTable() {
		symbols = new HashMap<String, Type>();
	}
	
	public void addSymbol(String name, Type type) {
		symbols.put(name, type);
	}
	
	public Map<String, Type> getSymbols() {
		return symbols;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (Entry<String, Type> entry : symbols.entrySet()) {
			sb.append(entry.getKey() + ": " + entry.getValue().getName());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
