package ql.ast.expression.binary;

import ql.ast.expression.Binary;
import ql.ast.expression.Expression;
import ql.ast.expression.literal.IntLiteral;
import ql.ast.value.Int;

public class Plus extends Binary {
	
	private IntLiteral leftInt = (IntLiteral) this.left;
	private IntLiteral rightInt = (IntLiteral) this.right;
	
	public Plus(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Int evaluate() {
		Integer l = leftInt.evaluate().getValue();
		Integer r = rightInt.evaluate().getValue();
		return new Int(l + r);
	}
	
}
