package ql.errorhandling;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.prettyprinter.PrettyPrinter;

public abstract class Error {
	private QLNode origin;
	private String errorMessage;
	
	public Error(QLNode origin, String errorMessage) {
		this.origin = origin;
		this.errorMessage = errorMessage;
	}
	
	public QLNode getOrigin() {
		return origin;
	}
	
	public String getOriginClass() {
		return origin.getClass().getSimpleName();
	}
	
	private String getErrorSourceString() {
		StringBuilder errorSourceString = new StringBuilder("-- Error Source Node -- \n");
		
		if(origin instanceof Expression) {
			errorSourceString.append(PrettyPrinter.stringify((Expression) origin, "   -> "));
		} else {
			errorSourceString.append(PrettyPrinter.stringify((Statement) origin, "   -> "));
		}
		
		return errorSourceString.toString();
	}
	
	public String getMessage() {
		return "[" + this.getClass().getSimpleName() + "]: " + errorMessage + "\n"
				+ getErrorSourceString();
	}
}
