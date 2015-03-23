package uva.ql.ast.expressions.math;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.CodeLines;
import uva.ql.ast.expressions.*;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Addition extends BinaryExpressions{
	
	public Addition(Expression _left, Expression _right, CodeLines _codeLines) {
		super(_left, _right, Operator.ADD, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitAddition(this);
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue((int)this.getLeftExpr().evaluate().getValue()).addition(new NumberValue((int)this.getRightExpr().evaluate().getValue()));
	}
	
	@Override
	public Object getEvaluatedValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public String toString(){
		return "Addition(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}

}
