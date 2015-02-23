package uva.ql.ast.expressions;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.VisitorInterface;

public class Type extends Expression{
	
	private PrimitiveType type;
	private String name;
	
	public Type(String _name, CodeLines _codeLines){
		super(_codeLines);
		
		PrimitiveType _type = PrimitiveType.findOperator(_name);
		if (_type != null){
			this.type = _type;
		}
		this.name = _name;
	}
	public String getTypeName(){
		if (this.name.equals("Float")) return "decimal";
		return this.name;
	}
	public PrimitiveType getPrimitiveType(){
		return this.type;
	}
	@Override
	public String toString(){
		return "PrimitiveType(" + this.name + ")";
	}
	@Override
	public GenericValue<?> evaluate() {
		return null;
	}
	@Override
	public <T> T accept(VisitorInterface<T> visitor) {
		return visitor.visitType(this);
	}
}
