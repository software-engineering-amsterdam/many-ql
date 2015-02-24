package lang.ql.ast.statement;

/**
 * Created by bore on 24/02/15.
 */
public interface StatVisitor<T>
{
    T visit(Question q);
    T visit(CalculatedQuestion q);
    T visit(IfCondition c);
}
