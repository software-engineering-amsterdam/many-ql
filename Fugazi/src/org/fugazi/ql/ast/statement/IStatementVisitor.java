package org.fugazi.ql.ast.statement;

public interface IStatementVisitor<T> {

    public T visitQuestion(Question _question);
    public T visitIfStatement(IfStatement _ifStatement);
    public T visitComputedQuestion(ComputedQuestion _computedQuestion);
}
