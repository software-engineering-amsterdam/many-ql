package org.uva.ql.ast.statement;


import org.uva.ql.ast.CodePosition;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.visitor.StatementVisitor;

public class IfElseStatement extends IfStatement {

	private final Block elseBlock;

	public IfElseStatement(Expression expr, Block ifBlock, Block elseBlock, CodePosition pos) {
		super(expr, ifBlock,pos);
		this.elseBlock = elseBlock;
	}

	public Block getElseBLock() {
		return elseBlock;
	}
	
	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return super.toString() + "\n\tElse Block = " + elseBlock.toString();
	}
}
