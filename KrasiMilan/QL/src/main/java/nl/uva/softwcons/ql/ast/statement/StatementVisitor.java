package nl.uva.softwcons.ql.ast.statement;

public interface StatementVisitor<T> {

    T visit(ComputedQuestion statement);

    T visit(Question statement);

    T visit(Conditional statement);

}
