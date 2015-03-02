package uva.ql.interpreter.typecheck;

import uva.ql.ast.CodeLines;

public class Symbol {

	protected String type;
	protected String className;
	protected CodeLines codeLines;
	protected Object content;	// optional field
	
	public Symbol (){
		super();
	}
	
	public Symbol (String _type, String _className, CodeLines _codeLines){
		this.type = _type;
		this.className = _className;
		this.codeLines = _codeLines;
	}
	
	public Symbol(String _type, String _className, CodeLines _codeLines, Object _content){
		this(_type, _className, _codeLines);
		this.content = _content;
	}
	
	public String getSymbolType() {
		return this.type;
	}
	
	public String getClassName() {
		return this.className;
	}
	
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	
	public Object getContent(){
		return this.content;
	}
	
	@Override
	public boolean equals(Object object){
		
		if (((Symbol)object).type == null || this.type == null)
			return this.className.equals(((Symbol)object).className);
		else 
			return this.className.equals(((Symbol)object).className) && this.type.equals(((Symbol)object).type);
	}
	
	@Override
	public String toString() {
		if (this.content != null)
			return '<' + this.className + ':' + this.type + " - " + this.content.toString() + '>';
		else 
			return '<' + this.className + ':' + this.type + '>';
	}
}

