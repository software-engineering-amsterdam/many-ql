package uva.ql.ast.expressions.logic;

import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.BinaryExpressions;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.Operator;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class NotEqual extends BinaryExpressions{

	public NotEqual(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.NOT_EQUAL, _codeLines);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitNotEqual(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new BooleanValue(this.getLeftExpr().evaluate().getValue() != this.getRightExpr().evaluate().getValue());
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
		return Arrays.asList(new TypeBoolean(), new TypeString(), new TypeMoney(), new TypeInteger());
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.NOT_EQUAL.getName() + this.getRightExpr();
	}
}
