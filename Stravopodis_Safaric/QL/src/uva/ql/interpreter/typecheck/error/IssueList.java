package uva.ql.interpreter.typecheck.error;

import java.util.ArrayList;
import java.util.List;

public class IssueList {
	
	private final List<IssueObject> issueList = new ArrayList<IssueObject>();
	
	public boolean hasErrors(){
		return !this.errorList().isEmpty();
	}
	
	public List<IssueObject> errorList(){
		List<IssueObject> issues = new ArrayList<IssueObject>();
		
		for (IssueObject issue : this.issueList){
			if (issue.issueIsError()){
				issues.add(issue);
			}
		}
		
		return issues;
	}
	
	public List<IssueObject> getErrorOfType(IssueType.ERROR errorType){
		List <IssueObject> issues = new ArrayList<IssueObject>();
		
		for (IssueObject issue : this.errorList()){
			if (issue.isOfErrorType(errorType)){
				issues.add(issue);
			}
		}
		
		return issues;
	}
	
	public void putIssue(IssueObject issueObject){
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
