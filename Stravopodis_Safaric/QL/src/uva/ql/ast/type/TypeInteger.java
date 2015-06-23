package uva.ql.ast.type;

import uva.ql.ast.CodeLines;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.TypeVisitor;

public class TypeInteger extends Type{

	public TypeInteger(){
		super();
	}
	
	public TypeInteger(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	@Override
	public NumberValue typeInitialValue() {
		return new NumberValue(0);
	}

	@Override
	public <T> T accept(TypeVisitor<T> visitor) {
		return visitor.visitTypeInteger(this);
	}
	
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}

}
