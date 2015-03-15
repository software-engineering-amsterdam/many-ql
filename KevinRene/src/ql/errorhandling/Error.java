package ql.errorhandling;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.visitor.prettyprinter.PrettyPrinter;
import ql.ast.visitor.prettyprinter.PrintWriter;

public abstract class Error implements PrintWriter {
	private QLNode origin;
	private String errorMessage, errorSourceStack;
	
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
	
	@Override
	public void printString(String output) {
		errorSourceStack = output;
	};
	
	private String getErrorSourceString() {
		if(origin instanceof Expression) {
			PrettyPrinter.print((Expression) origin, this, "   -> ");
		} else {
			PrettyPrinter.print((Statement) origin, this, "   -> ");
		}
		
		return errorSourceStack;
	}
	
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "]: " + errorMessage + "\n"
				+ "-- Error Source Node -- \n" + getErrorSourceString();
	}
}
	