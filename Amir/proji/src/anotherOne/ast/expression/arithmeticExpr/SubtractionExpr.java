package anotherOne.ast.expression.arithmeticExpr;

import java.util.List;
import java.util.Map;

import anotherOne.ast.IGlobalElement;
import anotherOne.ast.expression.Expression;
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.booleanExpr.BooleanExpressionEvaluationVisitor;

public class SubtractionExpr extends BinaryArithmeticExpr {

	public ArithmeticExpression left;
	public ArithmeticExpression right;
	
	public SubtractionExpr(ArithmeticExpression left, ArithmeticExpression right) {
		super(left, right);
	}

	public int accept(BooleanExpressionEvaluationVisitor visitor){
		return visitor.visit(this);//..visitAdditionExpr(toAdd);
	}

	@Override
	public void accept(VariablesCollectionVisitor visitor) {
		visitor.visit(this);
	}

}
