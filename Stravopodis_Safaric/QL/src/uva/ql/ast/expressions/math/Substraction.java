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

public class Substraction extends BinaryExpression{

	public Substraction(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public NumberValue evaluate() {
		int left = (int)this.getLeftExpressionValue();
		int right = (int)this.getRightExpressionValue();
		
		return new NumberValue(left).substraction(new NumberValue(right));
	}
	
	@Override
	public Object getValue() {
		return this.evaluate().getValue();
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public List<Type> acceptedTypes() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitSubstraction(this);
	}
	
	@Override
	public CodeLines getLinesOfCode() {
		return this.codeLines;
	}

	@Override
	public String toString(){
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
