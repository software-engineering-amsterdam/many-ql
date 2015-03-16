package uva.ql.interpreter.typecheck.table;

import java.util.HashMap;
import java.util.Map;

import uva.ql.interpreter.typecheck.error.*;
import uva.ql.interpreter.typecheck.error.IssueType.WARNING;
import uva.ql.supporting.table.Table;
import uva.ql.ast.*;

public class WarningTable extends Table <IssueType.WARNING, CodeLines>{

	private final Map<IssueType.WARNING, CodeLines> warningTable = new HashMap<IssueType.WARNING, CodeLines>();
	
	@Override
	public void putValue(WARNING key, CodeLines value) {
		this.warningTable.put(key, value);
	}

	@Override
	public boolean keyExists(WARNING key) {
		return this.warningTable.containsKey(key);
	}

	@Override
	public boolean valueExists(WARNING key, CodeLines value) {
		return false;
	}

	@Override
	public CodeLines retrieveValue(WARNING key) {
		return this.warningTable.get(key);
	}

	@Override
	public String toString() {
		return this.warningTable.toString();
	}

}
