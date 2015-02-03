package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class GT extends Expr<Boolean> {

	public GT(int expr, int expr2) {
		super(expr > expr2);
	}
}
