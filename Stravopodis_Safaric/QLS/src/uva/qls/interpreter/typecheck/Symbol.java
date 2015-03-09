package uva.qls.interpreter.typecheck;

import uva.qls.interpreter.typecheck.Symbol;
import uva.qls.ast.CodeLines;

public class Symbol {

	private String type;
	private String className;
	private CodeLines codeLines;
	private Object content;
	
	public Symbol (String _type, String _className, CodeLines _codeLines){
		this.codeLines=_codeLines;
		this.className=_className;
		this.type=_type;
	}
	
	
	public Symbol (String _type, String _className, CodeLines _codeLines, Object _object){
		this.codeLines=_codeLines;
		this.className=_className;
		this.type=_type;
		this.content=_object;
	}
	
	public Object getContent(){
		return this.content;
	}
	
	public String getSymbolType(){
		return this.type;
	}
	
	public CodeLines getCodeLine(){
		return this.codeLines;
	}
	public String getClassName(){
		return this.className;
	}
	
	@Override
	public boolean equals (Object _object){
		
		if (((Symbol)_object).type == null || this.type == null)
			return this.className.equals(((Symbol)_object).className);
		else 
			return this.className.equals(((Symbol)_object).className) && this.type.equals(((Symbol)_object).type);
	}
	
	@Override
	public String toString() {
		if (this.content != null)
			return '<' + this.className + ':' + this.type + " - " + this.content.toString() + '>';
		else 
			return '<' + this.className + ':' + this.type + '>';
	}
}

