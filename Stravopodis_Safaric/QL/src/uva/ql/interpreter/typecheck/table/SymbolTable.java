package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;


public class SymbolTable extends Table<String, SymbolTableValue>{

	private Map<String, SymbolTableValue> symbolMap;
	
	public SymbolTable(){
		this.symbolMap = new HashMap<String, SymbolTableValue>();
	}
	
	public Map<String, SymbolTableValue> getTable() {
		return this.symbolMap;
	}
	
	@Override
	public void putValue(String identifier, SymbolTableValue value) {
		this.symbolMap.put(identifier, value);
	}

	@Override
	public boolean keyExists(String identifier) {
		return this.symbolMap.keySet().contains(identifier);
	}

	@Override
	public boolean valueExists(String identifier, SymbolTableValue value) {
		return this.symbolMap.get(identifier) != null;
	}

	@Override
	public SymbolTableValue retrieveValue(String identifier) {
		return this.symbolMap.get(identifier);
	}
	
	@Override
	public String toString() {
		String s = "";
		for (String key : this.symbolMap.keySet())
			s += key + " " + this.symbolMap.get(key) + " ";
		return s;
	}
}
