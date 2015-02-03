package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Mul extends Expr<Integer> {

	public Mul(int expr, int expr2) {
		super(expr * expr);
	}
}
