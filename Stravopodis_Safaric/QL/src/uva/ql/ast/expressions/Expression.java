package uva.ql.ast.expressions;
import uva.ql.ast.*;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;

public abstract class Expression extends ASTNode {
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public CodeLines getCodeLines(){
		return this.codeLines;
	}
	
	public abstract GenericValue<?> evaluate();
	public abstract String evaluateType();
	public abstract <T> T accept(ExpressionVisitorInterface<T> visitor);
	
}
