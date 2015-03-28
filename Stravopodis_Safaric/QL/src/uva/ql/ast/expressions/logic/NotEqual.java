package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpression;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class NotEqual extends BinaryExpression{

	public NotEqual(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.NOT_EQUAL, _codeLines);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.getLeftExpressionValue() != this.getRightExpressionValue());
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
		return Arrays.asList(new TypeBoolean(), new TypeString(), new TypeMoney(), new TypeInteger());
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitNotEqual(this);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.NOT_EQUAL.getName() + this.getRightExpr();
	}
}
