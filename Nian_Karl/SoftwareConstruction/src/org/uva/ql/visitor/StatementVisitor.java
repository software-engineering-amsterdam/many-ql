package org.uva.ql.visitor;

import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionComputed;
import org.uva.ql.ast.statement.QuestionNormal;

public interface StatementVisitor<T> {
	public T visit(Block block);

	public T visit(QuestionNormal question);

	public T visit(QuestionComputed question);

	public T visit(IfStatement ifStatement);

	public T visit(IfElseStatement ifElseStatement);
}
