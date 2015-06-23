package uva.qls.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.qls.ast.literal.*;

public class SymbolTable {

	private Map <String, SymbolTableValue> symbolMap;
	
	public SymbolTable(){
		this.symbolMap = new HashMap<String,SymbolTableValue>();
	}

	public Map<String, SymbolTableValue> getTable(){
		return this.symbolMap;
	}
	
	public boolean keyExists(Identifier identifier) {
		return this.retrieveValue(identifier) != null;
	}

	public boolean valueExists(Identifier identifier, SymbolTableValue value) {
		return this.symbolMap.get(identifier.evaluatedValue())!=null;
	}
	
	public void putValue(Identifier identifier, SymbolTableValue value) {
		this.symbolMap.put(identifier.evaluatedValue(), value);
	}

	public SymbolTableValue retrieveValue(Identifier identifier) {
		return this.symbolMap.get(identifier.evaluatedValue());
		
	}

	@Override
	public String toString() {
		String s = "";
		for (String key : this.symbolMap.keySet())
			s += key + " " + this.symbolMap.get(key) + " ";
		return s;
	}
	
}
