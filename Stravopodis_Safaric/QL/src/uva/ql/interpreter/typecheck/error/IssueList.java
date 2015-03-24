package uva.ql.interpreter.typecheck.error;

import java.util.ArrayList;
import java.util.List;

public class IssueList {
	
	private final List<IssueObject> issueList = new ArrayList<IssueObject>();
	
	public boolean hasErrors(){
		for (IssueObject issue : this.issueList){
			if (issue.issueIsError()){
				return true;
			}
		}
		return false;
	}
	
	public void putIssueObject(IssueObject issueObject){
		this.issueList.add(issueObject);
	}
	
	public List<IssueObject> getIssueList(){
		return this.issueList;
	}
	
	public void printIssues(){
		for (IssueObject issue : this.issueList){
			System.err.println(issue.toString());
		}
	}
	
	@Override
	public String toString(){
		return this.issueList.toString();
	}
	
}
