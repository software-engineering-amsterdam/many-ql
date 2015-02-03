package org.uva.sea.ql.ast.expr.unary;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Unary;

public class Neg extends Unary {

	final static String operator = "-";
	
	public Neg(Expr operand) {
		super(operand, operator);
	}
}
