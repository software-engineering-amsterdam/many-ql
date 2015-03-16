package uva.ql.ast.expressions;
import java.util.List;

import uva.ql.ast.*;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitorInterface;
import uva.ql.ast.type.*;

public abstract class Expression extends ASTNode {
	
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(ExpressionVisitorInterface<T> visitor);
	public abstract List<Type> getValueType();
	public abstract List<Type> getSupportedType();
	public abstract CodeLines getCodeLine();
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	
}
