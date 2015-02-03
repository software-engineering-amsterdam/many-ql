package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Add extends Expr<Integer> {

	public Add(int expr, int expr2) {
		super(expr + expr2);
	}
}
