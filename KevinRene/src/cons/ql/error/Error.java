package cons.ql.error;

import cons.ql.ast.ASTNode;

public class Error {
	private ASTNode origin;
	private String errorMessage;
	
	public Error(ASTNode origin, String errorMessage) {
		this.origin = origin;
		this.errorMessage = errorMessage;
	}
	
	public ASTNode getErrorOrigin() {
		return origin;
	}
	
	public String getErrorOriginClass() {
		return origin.getClass().getSimpleName();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
