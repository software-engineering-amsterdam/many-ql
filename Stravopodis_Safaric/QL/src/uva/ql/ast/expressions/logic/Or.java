package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpression;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Or extends BinaryExpression{

	public Or(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.OR, _codeLines);
	}
	
	@Override
	public BooleanValue evaluate() {		
		boolean left = (boolean)this.getLeftExpressionValue();
		boolean right = (boolean)this.getRightExpressionValue();
		
		return new BooleanValue(left).or(new BooleanValue(right));
	}
	
	@Override
	public Object getValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> acceptedTypes() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitOr(this);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}

	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.OR.getName() + this.getRightExpr();
	}
}
