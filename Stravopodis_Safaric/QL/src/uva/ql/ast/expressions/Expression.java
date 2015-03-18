package uva.ql.ast.expressions;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public abstract class Expression extends ASTNode {
	
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	public abstract List<Type> possibleReturnTypes();
	public abstract List<Type> getSupportedType();
	public abstract CodeLines getCodeLine();
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public boolean isBoolean() {
		return possibleReturnTypes().equals(Arrays.asList(new TypeBoolean()));
	}
	
}
