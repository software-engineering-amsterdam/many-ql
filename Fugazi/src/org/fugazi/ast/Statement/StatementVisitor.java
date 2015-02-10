package org.fugazi.ast.Statement;

public interface StatementVisitor<T> {

    public T visit(ComputedQuestionStatement assignQuestStatement);
    public T visit(IfStatement ifStatement);
    public T visit(QuestionStatement questionStatement);
}
