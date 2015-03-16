package uva.ql.interpreter.typecheck.error;

import uva.ql.ast.CodeLines;

public class IssueObject {

	private CodeLines codeLines;
	private Object object;
	
	public IssueObject(CodeLines _codeLines, Object _object){
		this.codeLines = _codeLines;
		this.object = _object;
	}
	
	@Override
	public String toString(){
		return "ErrorTypeObject(" + this.codeLines + "," + this.object + ")";
	}
	
}
