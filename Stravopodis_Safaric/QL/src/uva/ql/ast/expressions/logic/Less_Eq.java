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
import uva.ql.ast.value.BooleanValue;
import uva.ql.ast.value.NumberValue;
import uva.ql.ast.visitor.ExpressionVisitor;

public class Less_Eq extends BinaryExpressions{

	public Less_Eq(Expression _left, Expression _right, CodeLines _codeLines){
		super(_left, _right, Operator.LESS_EQ, _codeLines);
	}
	
	@Override
	public CodeLines getCodeLine() {
		return this.codeLines;
	}
	
	@Override
	public <T> T accept(ExpressionVisitor<T> visitor) {
		return visitor.visitLessEqual(this);
	}
	
	@Override
	public BooleanValue evaluate() {
		return new NumberValue((int)this.getLeftExpr().evaluate().getValue()).lessEqual(new NumberValue((int)this.getRightExpr().evaluate().getValue()));
	}
	
	@Override
	public List<Type> possibleReturnTypes() {
		return Arrays.asList(new TypeBoolean());
	}
	
	@Override
	public List<Type> getSupportedType() {
		return Arrays.asList(new TypeInteger(), new TypeMoney());
	}
	
	@Override
	public String toString(){
		return this.getLeftExpr() + Operator.LESS_EQ.getName() + this.getLeftExpr();
	}
}
