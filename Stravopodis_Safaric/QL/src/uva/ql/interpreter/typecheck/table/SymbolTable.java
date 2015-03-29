package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;
import uva.ql.ast.type.*;

public class SymbolTable  {

	private final Map<String, Type> symbolTable = new HashMap<String, Type>();
	
	public void putValue(String key, Type value) {
		this.symbolTable.put(key, value);
	}

	public boolean keyExists(String key) {
		return this.symbolTable.containsKey(key);
	}

	public boolean typeEqualsTo(String key, Type value) {
		
		if (this.keyExists(key)){
			return this.symbolTable.get(key).equals(value);
		}
		
		return false;
	}

	public Type retrieveType(String fromIdentifier) {
		return this.symbolTable.get(fromIdentifier);
	}

	@Override
	public String toString() {
		return this.symbolTable.toString();
	}
}
