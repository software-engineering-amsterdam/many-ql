package uva.ql.ast.expressions;
import uva.ql.ast.*;
import uva.ql.ast.value.GenericValue;

public abstract class Expression extends ASTNode {
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
}
