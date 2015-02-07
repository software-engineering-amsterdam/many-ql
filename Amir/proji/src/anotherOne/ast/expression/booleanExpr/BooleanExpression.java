package anotherOne.ast.expression.booleanExpr;

import anotherOne.ast.expression.Expression;
import anotherOne.ast.expression.VariablesCollectionVisitor;

public interface BooleanExpression extends Expression {

	public boolean accept(BooleanExpressionEvaluationVisitor visitor);
//
	public void accept(VariablesCollectionVisitor visitor);

}
