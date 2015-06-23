package uva.ql.interpreter.typecheck.error;

import uva.ql.ast.CodeLines;

public class IssueObject {

	private IssueType.ERROR issueTypeError;
	private IssueType.WARNING issueTypeWarning;
	private CodeLines codeLines;
	private Object object;
	
	public IssueObject(IssueType.ERROR issueType, Object object, CodeLines codeLines){	
		this.issueTypeError = issueType;
		this.object = object;
		this.codeLines = codeLines;
	}
	
	public IssueObject(IssueType.WARNING issueType, Object object, CodeLines codeLines){
		this.issueTypeWarning = issueType;
		this.object = object;
		this.codeLines = codeLines;
	}
	
	public boolean issueIsError(){
		return this.issueTypeError != null;
	}
	
	public boolean issueIsWarning(){
		return this.issueTypeWarning != null;
	}
	
	public boolean isOfErrorType(IssueType.ERROR error){
		if (error == null){
			return false;
		}
		
		return this.issueTypeError == error;
	}
	
	@Override
	public String toString(){
		if (this.issueTypeError != null){
			return "Error of type: " + this.issueTypeError + "," + this.object + ", at code lines: " + this.codeLines + ")";
		}
		else {
			return "Warning of type: " + this.issueTypeWarning + "," + this.object + ", at code lines: " + this.codeLines + ")";
		}
	}
	
}
