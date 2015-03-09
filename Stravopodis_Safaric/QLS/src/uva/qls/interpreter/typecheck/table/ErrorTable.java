package uva.qls.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.qls.ast.CodeLines;

public class ErrorTable extends Table<String, CodeLines> {
	
	private Map<String, CodeLines> errorTable;
	
	public ErrorTable(){
		this.errorTable = new HashMap<String,CodeLines>();
	}

	public Map<String, CodeLines> getTable(){
		return this.errorTable;
	}
	@Override
	public void putValue(String identifier, CodeLines value) {
		this.errorTable.put(identifier, value);
		
	}

	@Override
	public boolean keyExists(String identifier) {
		
		//Not needed to be implemented 
		return false;
	}

	@Override
	public boolean valueExists(String identifier, CodeLines value) {
		//Not needed to be implemented 
		return false;
	}

	@Override
	public CodeLines retrieveValue(String identifier) {
		//Not needed to be implemented 
		return null;
	}

	@Override
	public String toString() {
		String s = "";
		for (String key : this.errorTable.keySet())
			s += key + " " + this.errorTable.get(key).getCodeLocation().toString() + " ";
		return s;
	}
}
