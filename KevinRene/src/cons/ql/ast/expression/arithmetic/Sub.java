package cons.ql.ast.expression.arithmetic;

import cons.ql.ast.Expression;
import cons.ql.ast.expression.Binary;
import cons.ql.ast.expression.QLType;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.visitor.Visitor;

public class Sub extends Binary {
	public Sub(Expression left, Expression right) {
		super(left, right, "-");
	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {		
		return visitor.visit(this);
	}
	
	//TODO: Add a superclass for numeric types.
	@Override
	public QLType getType() {
		return new QLNumeric();
	}
}
