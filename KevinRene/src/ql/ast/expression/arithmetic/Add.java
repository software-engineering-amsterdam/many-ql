package ql.ast.expression.arithmetic;

import ql.ast.Expression;
import ql.ast.expression.Binary;
import ql.ast.expression.QLType;
import ql.ast.expression.type.QLNumeric;
import ql.ast.visitor.Visitor;

public class Add extends Binary {
	public Add(Expression left, Expression right) {
		super(left, right, "+");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	@Override
	public QLType getType() {
		return new QLNumeric();
	}

}
