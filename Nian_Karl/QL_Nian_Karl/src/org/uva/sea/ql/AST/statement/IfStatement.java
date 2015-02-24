package org.uva.sea.ql.AST.statement;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.AST.Visitable;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.value.BooleanValue;
import org.uva.sea.ql.AST.visitor.Visitor;

public class IfStatement extends Statement {

	private BlockStatement block;

	private final Expression expr;

	public IfStatement(Expression expr, BlockStatement block) {
		this.expr = expr;
		this.block = block;
	}

	public Expression getExpr() {
		return expr;
	}

	public BlockStatement getBlock() {
		return block;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
