package org.uva.ql.ast.statement;


import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.visitor.Visitor;

public class IfElseStatement extends IfStatement {

	private BlockStatement elseBlock;

	public IfElseStatement(Expression expr, BlockStatement ifBlock, BlockStatement elseBlock) {
		super(expr, ifBlock);
		this.elseBlock = elseBlock;
	}

	public BlockStatement getElseBLock() {
		return elseBlock;

	}
	
	@Override
	public <T> T accept(Visitor<T> visitor) {
		return visitor.visit(this);
	}

}
