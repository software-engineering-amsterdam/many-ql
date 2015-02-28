package nl.uva.softwcons.ast.statement;

public interface StatementVisitor<T> {

    T visit(ComputedQuestion statement);

    T visit(Question statement);

    T visit(Conditional statement);

}
