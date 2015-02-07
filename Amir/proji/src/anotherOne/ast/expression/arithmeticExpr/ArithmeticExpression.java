package anotherOne.ast.expression.arithmeticExpr;

import java.util.List;
import java.util.Map;

import anotherOne.ast.expression.Expression;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.booleanExpr.BooleanExpressionEvaluationVisitor;

public interface ArithmeticExpression extends Expression {
	
//	public int getValue();
	public int accept(BooleanExpressionEvaluationVisitor visitor);
	// accept (binaryExpressioinvisitor)
	public void accept(VariablesCollectionVisitor visitor);
}
// fix hierarchy - arithmetic / binary