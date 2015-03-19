package uva.ql.interpreter.typecheck.error;

import java.util.*;

public class IssueTable{

	private final Map<IssueType.ERROR, IssueTableList> errorTable = new HashMap<IssueType.ERROR, IssueTableList>();
	
	public Map<IssueType.ERROR, IssueTableList> getTable(){
		return this.errorTable;
	}
	
	public boolean hasIssues(){
		return this.errorTable.isEmpty();
	}
	
	public void putValue(IssueType.ERROR key, IssueObject value) {

		if (this.errorTable.containsKey(key)){
			this.errorTable.get(key).putValue(value);
		}
		else {
			this.errorTable.put(key, new IssueTableList(value));
		}
	}

	public boolean keyExists(IssueType.ERROR key) {
		return this.errorTable.containsKey(key);
	}

	public boolean valueExists(IssueType.ERROR key, IssueObject value) {
		return this.errorTable.get(key).valueExists(value);
	}

	public IssueObject retrieveValue(IssueType.ERROR key) {
		return null;
	}
	
	public IssueTableList retrieveValues(IssueType.ERROR key){
		return this.errorTable.get(key);
	}

	@Override
	public String toString() {
		return this.errorTable.toString();
	}

}
