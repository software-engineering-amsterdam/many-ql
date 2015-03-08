package uva.qls.interpreter.typecheck.table;

import uva.qls.ast.CodeLines;
import uva.qls.ast.primitive.PrimitiveType;
import uva.qls.ast.primitive.Type;

public class SymbolTableValue {

	
	protected Type type;
	protected CodeLines codeLines;
	
	public SymbolTableValue (Type type, CodeLines codeLines){
		this.type = type;
		this.codeLines = codeLines;
	}
	
	public CodeLines getSourceCodeLines(){
		return this.codeLines;
	}
	
	public Type getType(){
		return this.type;
	}
	
	public PrimitiveType getPrimitiveType(){
		return this.type.getPrimitiveType();
	}
	
	@Override
	public String toString(){
		return this.getType() != null 	? "SymbolTableValue(" + this.type.toString() + ")"
										: "SymbolTableValue()"; 
	}
}
