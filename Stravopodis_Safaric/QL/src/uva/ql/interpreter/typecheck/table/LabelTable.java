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

	public CodeLines retrieveLabel(String fromIdentifier) {
		return this.labelTable.get(fromIdentifier);
	}

	@Override
	public String toString() {
		return this.labelTable.toString();
	}

}
