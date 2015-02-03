package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class LEq extends Expr<Boolean> {

	public LEq(int expr, int expr2) {
		super(expr <= expr2);
	}
}
