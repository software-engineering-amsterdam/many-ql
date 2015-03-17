package uva.sc.ql.ast;

import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;

public interface IQLStatementNodeVisitor<T> {

    public T visit(Question question);

    public T visit(IfStatement ifStatement);
}
