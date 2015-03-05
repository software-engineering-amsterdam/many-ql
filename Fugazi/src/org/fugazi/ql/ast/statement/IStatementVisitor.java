package org.fugazi.ql.ast.statement;

public interface IStatementVisitor<T> {

    public T visitQuestion(Question question);
    public T visitIfStatement(IfStatement ifStatement);
    public T visitComputedQuestion(ComputedQuestion assignQuest);
}
