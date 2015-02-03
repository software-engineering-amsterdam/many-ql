package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class LT extends Expr<Boolean> {

	public LT(int expr, int expr2) {
		super(expr < expr2);
	}
}
