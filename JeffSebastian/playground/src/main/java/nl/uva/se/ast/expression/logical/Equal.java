package nl.uva.se.ast.expression.logical;

import nl.uva.se.ast.expression.Binary;
import nl.uva.se.ast.expression.Expression;
import nl.uva.se.visitor.Visitor;

public class Equal extends Binary{

	public Equal(int lineNumber, int offset, Expression left, Expression right) {
		super(lineNumber, offset, left, right);
		}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
