package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Or extends BinaryExpressions{

	public Or(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.OR, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitOr(this);
	}
	
	@Override
	public GenericValue<?> evaluate() {		
		return new BooleanValue((boolean)this.getLeftExpr().evaluate().getValue()).or(new BooleanValue((boolean)this.getRightExpr().evaluate().getValue()));
	}
	
	@Override
	public Object getEvaluatedValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeBoolean());
	}

	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.OR.getName() + this.getRightExpr();
	}
}
