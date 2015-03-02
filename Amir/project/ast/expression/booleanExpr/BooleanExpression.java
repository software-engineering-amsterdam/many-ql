package project.ast.expression.booleanExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.Expression;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.value.TypeValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public interface BooleanExpression extends Expression {

	public TypeValue getType();

	public Value accept(ExpressionEvaluationVisitor visitor);
//
	public void accept(VariablesCollectionVisitor visitor);

	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor);

	
//	public void accept(ForbidReferencesVisitor visitor);
}
