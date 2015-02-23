package uva.ql.ast.expressions;
import uva.ql.ast.*;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.VisitorInterface;

public abstract class Expression extends ASTNode {
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(VisitorInterface<T> visitor);
	
}
