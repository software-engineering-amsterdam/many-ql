package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Div extends Expr<Integer> {

	public Div(int expr, int expr2) {
		super(expr / expr2);
	}
}
