package project.ast.expression.booleanExpr;

import java.util.HashSet;

import project.TypeCheckVisitor;
import project.ast.expression.VariablesCollectionVisitor;
import project.ast.expression.unaryExpression.UnaryExpression;
import project.ast.value.BooleanTypeValue;
import project.ast.value.TypeValue;
import project.ast.values.BoolValue;
import project.ast.values.Value;
import project.typeChecking.ErrorObject;

public class NotExpr implements BooleanExpression, UnaryExpression//implements BooleanExpression
{
	public BooleanExpression subExpr;
	
	public NotExpr(BooleanExpression expr) {
		this.subExpr = expr;
	}

	@Override
	public Value accept(ExpressionEvaluationVisitor visitor){//, Map<String, Id> varsMap) {
		return visitor.visit(this);//, varsMap);
	}

	public void accept(VariablesCollectionVisitor visitor){
	visitor.visit(this);
}

	@Override
	public TypeValue getType() {
		return new BooleanTypeValue();
	}

	@Override
	public HashSet<ErrorObject> accept(TypeCheckVisitor visitor) {
		return visitor.visit(this);
	}

	@Override
	public Value evaluate(Value value) {
		return new BoolValue(!(boolean)value.getValue());
	}

}
