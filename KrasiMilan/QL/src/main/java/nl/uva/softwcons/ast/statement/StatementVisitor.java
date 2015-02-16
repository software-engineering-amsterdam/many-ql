package nl.uva.softwcons.ast.statement;


public interface StatementVisitor<T> {

    T visit(Block statement);

    T visit(ComputedQuestion statement);

    T visit(Question statement);

    T visit(Conditional statement);

}
