package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class GEq extends Expr<Boolean> {

	public GEq(int expr, int expr2) {
		super(expr >= expr2);
	}
}
