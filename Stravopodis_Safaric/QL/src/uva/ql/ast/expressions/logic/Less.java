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
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Less extends BinaryExpression{

	public Less(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.LESS, _codeLines);
	}
	
	@Override
	public BooleanValue evaluate() {
		int left = (int)this.getLeftExpressionValue();
		int right = (int)this.getRightExpressionValue();
		
		return new NumberValue(left).less(new NumberValue(right));	
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
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitLess(this);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.LESS.getName() + this.getLeftExpr();
	}
}
