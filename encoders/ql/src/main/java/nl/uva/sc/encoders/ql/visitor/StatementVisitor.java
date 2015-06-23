package nl.uva.sc.encoders.ql.visitor;

import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;

public interface StatementVisitor<T> {

	T visit(Question question);

	T visit(ConditionalBlock conditionalBlock);
}
