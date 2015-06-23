package uva.qls.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.qls.ast.CodeLines;

public class ErrorTable {
	
	private Map<String, CodeLines> errorTable;
	
	public ErrorTable(){
		this.errorTable = new HashMap<String,CodeLines>();
	}

	public Map<String, CodeLines> getTable(){
		return this.errorTable;
	}
	
	public void putValue(String identifier, CodeLines value) {
		this.errorTable.put(identifier, value);
		
	}

	public CodeLines retrieveValue(String identifier) {
		return this.errorTable.get(identifier);
	}

	@Override
	public String toString() {
		String s = "";
		for (String key : this.errorTable.keySet())
			s += key + " " + this.errorTable.get(key).getCodeLocation().toString() + " ";
		return s;
	}
}
