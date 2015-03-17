package uva.ql.interpreter.typecheck.error;

import java.util.ArrayList;
import java.util.List;

public class IssueTableList {
	
	private final List<IssueObject> errorLOCList = new ArrayList<IssueObject>();
	
	public IssueTableList(IssueObject value){
		this.errorLOCList.add(value);
	}
	
	public List<IssueObject> retrieveValues(){
		return this.errorLOCList;
	}
	
	public void putValue(IssueObject codeLines){
		this.errorLOCList.add(codeLines);
	}
	
	public boolean valueExists(IssueObject obj){
		for (IssueObject value : this.errorLOCList){
			if (obj.equals(value)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.errorLOCList.toString();
	}
}
