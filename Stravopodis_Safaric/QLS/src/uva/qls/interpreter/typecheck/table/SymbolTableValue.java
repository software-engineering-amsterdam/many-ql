package uva.qls.interpreter.typecheck.table;

import uva.qls.ast.CodeLines;

public class SymbolTableValue {
	
	protected CodeLines codeLines;
	
	public SymbolTableValue (CodeLines codeLines){
		this.codeLines = codeLines;
	}
	
	public CodeLines getSourceCodeLines(){
		return this.codeLines;
	}

}
