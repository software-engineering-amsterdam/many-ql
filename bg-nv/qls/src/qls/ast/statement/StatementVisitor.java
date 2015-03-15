package qls.ast.statement;

import qls.ast.statement.*;

/**
 * Created by bore on 03/03/15.
 */
public interface StatementVisitor<T>
{
    T visit(Section s);
    T visit(qls.ast.statement.Question q);
    T visit(QuestionWithRules q);
    T visit(DefaultStat d);
}

