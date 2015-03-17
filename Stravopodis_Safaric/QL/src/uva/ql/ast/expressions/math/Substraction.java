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

public class Substraction extends BinaryExpressions{

	public Substraction(Expression left, Expression right, CodeLines _codeLines) {
		super(left, right, Operator.SUB, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitSubstraction(this);
	}
	
	@Override
	public NumberValue evaluate() {
		return new NumberValue((int)this.getLeftExpr().evaluate().getValue()).substraction(new NumberValue((int)this.getRightExpr().evaluate().getValue()));
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
		return "Substraction(" + this.getLeftExpr() + "," + this.getRightExpr() + ")";
	}
}
