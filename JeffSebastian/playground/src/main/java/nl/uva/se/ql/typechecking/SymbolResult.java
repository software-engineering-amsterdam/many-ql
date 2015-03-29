package nl.uva.se.ql.typechecking;

import nl.uva.se.ql.typechecking.error.ErrorList;

public class SymbolResult {

	private ErrorList errorList;
	private SymbolTable symbols;
	
	public SymbolResult(ErrorList errorList, SymbolTable symbols) {
		this.errorList = errorList;
		this.symbols = symbols;
	}

	public ErrorList getErrorList() {
		return errorList;
	}

	public SymbolTable getSymbols() {
		return symbols;
	}
	
}
