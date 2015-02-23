package uva.ql.interpreter.typecheck;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;

public class Symbol {

	protected Type type;
	protected String className;
	protected CodeLines address;
	
	public Symbol (){
		super();
	}
	public Symbol (Type _type, String _className){
		this.type = _type;
		this.className = _className;
		//this.address = _address;
	}
	public Type getSymbolType() {
		return this.type;
	}
	public String getClassName() {
		return this.className;
	}
	/*public CodeLines getAddress() {
		return this.address;
	}*/
	@Override
	public String toString() {
		if(type != null) return '<' + this.className + ':' + this.type +'>';
		return getSymbolType().getTypeName();
	}
}


