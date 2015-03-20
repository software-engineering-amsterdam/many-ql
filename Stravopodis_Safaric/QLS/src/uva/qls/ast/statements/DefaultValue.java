package uva.qls.ast.statements;

import uva.qls.ast.CodeLines;
import uva.qls.ast.component.Component;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.style.visitor.StyleTable;
import uva.qls.ast.type.Type;

public class DefaultValue extends Statement {
	
	private Type type;
	private Component component;
	private StyleTable style;

	public DefaultValue (Type _type, Component _component, CodeLines _codeLines ){
		super(_codeLines);
		this.component = _component;
		this.type = _type;
	}
	
	public DefaultValue(Type _type, StyleTable _style, CodeLines _codeLines){
		super(_codeLines);
		this.style = _style;
		this.type = _type;
	}
	
	public Type getType(){
		return this.type;
	}
	public StyleTable getStyle(){
		return this.style;
	}
	
	public Component getComponent(){
		return this.component;
	}
	
	public CodeLines getLOC(){
		return this.codeLines;
	}
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return this.component != null 	? visitor.visitDefaultValueComponent(this)
										: visitor.visitDefaultValueStatements(this);
	}
	
	@Override
	public String toString(){
		return this.style 		!= null ? "DefaultValue(" + this.getType().toString() + "," + this.style.toString()
								: "DefaultValue(" + this.getType().toString() + "," + this.component.toString() + ")";
	}
}
