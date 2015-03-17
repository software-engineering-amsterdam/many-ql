package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;
import uva.ql.ast.*;

public class LabelTable {

	private final Map<String, CodeLines> labelTable = new HashMap<String, CodeLines>();
	
	public void putValue(String key, CodeLines value) {
		this.labelTable.put(key, value);
	}

	public boolean keyExists(String key) {
		return this.labelTable.containsKey(key);
	}

	public boolean valueExists(String key, CodeLines value) {
		return this.keyExists(key);	// If there is a key, so is the value
	}

	public CodeLines retrieveValue(String key) {
		return this.labelTable.get(key);
	}

	@Override
	public String toString() {
		return this.labelTable.toString();
	}

}
