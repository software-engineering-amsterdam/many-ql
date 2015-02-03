package org.uva.sea.ql.ast.expr;

import org.uva.sea.ql.ast.Expr;

public class Neg extends Expr<Integer> {

	public Neg(int expr) {
		super(expr * -1);
	}
}
