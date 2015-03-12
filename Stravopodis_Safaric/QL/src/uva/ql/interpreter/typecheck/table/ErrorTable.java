package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.ql.ast.CodeLines;

public class ErrorTable extends Table<String, CodeLines>{

	private Map<String, CodeLines> errorTable;
	
	public ErrorTable(){
		this.errorTable = new HashMap<String, CodeLines>();
	}
	
	public Map<String, CodeLines> getTable() {
		return this.errorTable;
	}
	
	@Override
	public boolean valueExists(String identifier, CodeLines value) {
		return false;
	}

	@Override
	public CodeLines retrieveValue(String identifier) {
		return null;
	}
	
	@Override
	public void putValue(String identifier, CodeLines value) {
		this.errorTable.put(identifier, value);
	}

	@Override
	public boolean keyExists(String identifier) {
		return false;
	}
	
	@Override
	public String toString() {
		String s = "";
		for (String key : this.errorTable.keySet())
			s += key + " " + this.errorTable.get(key).getLOCTuple().toString() + " ";
		return s;
	}

}
