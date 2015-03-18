package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.ql.interpreter.typecheck.error.*;
import uva.ql.interpreter.typecheck.error.IssueType.WARNING;
import uva.ql.ast.*;

public class WarningTable {

	private final Map<IssueType.WARNING, CodeLines> warningTable = new HashMap<IssueType.WARNING, CodeLines>();
	
	public boolean hasWarnings(){
		return this.warningTable.isEmpty();
	}
	
	public Map<IssueType.WARNING, CodeLines> getTable(){
		return this.warningTable;
	}
	
	public void putValue(WARNING key, CodeLines value) {
		this.warningTable.put(key, value);
	}

	public boolean keyExists(WARNING key) {
		return this.warningTable.containsKey(key);
	}

	public boolean valueExists(WARNING key, CodeLines value) {
		return false;
	}

	public CodeLines retrieveValue(WARNING key) {
		return this.warningTable.get(key);
	}

	@Override
	public String toString() {
		return this.warningTable.toString();
	}

}
