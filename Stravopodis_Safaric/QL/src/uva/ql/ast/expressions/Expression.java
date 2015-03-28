package uva.ql.ast.expressions;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.Node;
import uva.ql.ast.CodeLines;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public abstract class Expression extends Node {
	
	public abstract GenericValue<?> evaluate();
	public abstract Object getValue();
	
	public abstract List<Type> possibleReturnTypes();
	public abstract List<Type> acceptedTypes();
	
	public abstract CodeLines getLinesOfCode();
	
	public abstract <T> T accept(ExpressionVisitor<T> visitor);
	
	public Expression(){}
	
	public Expression(CodeLines _codeLines) {
		super(_codeLines);
	}
	
	public boolean isBoolean() {
		return possibleReturnTypes().equals(Arrays.asList(new TypeBoolean()));
	}
	
	public boolean isIdentifier(){
		return this.possibleReturnTypes().equals(Arrays.asList(new TypeString()));
	}
}
