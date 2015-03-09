package ql.error;

import ql.ast.QLNode;

public class Error {
	private QLNode origin;
	private String errorMessage;
	
	public Error(QLNode origin, String errorMessage) {
		this.origin = origin;
		this.errorMessage = errorMessage;
	}
	
	public QLNode getErrorOrigin() {
		return origin;
	}
	
	public String getErrorOriginClass() {
		return origin.getClass().getSimpleName();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
