package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.StringValue;
import uva.ql.ast.visitor.TypeVisitor;

public class TypeString extends Type{

	public TypeString(){
		super();
	}
	
	public TypeString(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	@Override
	public StringValue typeInitialValue() {
		return new StringValue("");
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visitTypeString(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}

}
