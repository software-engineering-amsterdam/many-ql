package uva.qls.ast.type;

import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;

public class TypeString extends Type {
	
	public TypeString(CodeLines _codeLines){
		super(_codeLines);
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitTypeString(this);
	}
	@Override
	public String toString(){
		return this.getClass().getSimpleName() + "()";
	}

}
