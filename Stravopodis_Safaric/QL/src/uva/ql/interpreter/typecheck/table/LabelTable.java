package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.ql.supporting.table.Table;
import uva.ql.ast.*;

public class LabelTable extends Table<String, CodeLines>{

	private final Map<String, CodeLines> labelTable = new HashMap<String, CodeLines>();
	
	@Override
	public void putValue(String key, CodeLines value) {
		this.labelTable.put(key, value);
	}

	@Override
	public boolean keyExists(String key) {
		return this.labelTable.containsKey(key);
	}

	@Override
	public boolean valueExists(String key, CodeLines value) {
		return this.keyExists(key);	// If there is a key, so is the value
	}

	@Override
	public CodeLines retrieveValue(String key) {
		return this.labelTable.get(key);
	}

	@Override
	public String toString() {
		return this.labelTable.toString();
	}

}
