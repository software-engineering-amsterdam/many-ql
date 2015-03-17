package qls.ast.statement;

/**
 * Created by bore on 15/03/15.
 */
public abstract class DefaultStatementVisitor<T> implements StatementVisitor<T>
{
    public abstract T visitDefault(Statement s);

    @Override
    public T visit(Section s)
    {
        return this.visitDefault(s);
    }

    @Override
    public T visit(Question q)
    {
        return this.visitDefault(q);
    }

    @Override
    public T visit(QuestionWithRules q)
    {
        return this.visitDefault(q);
    }

    @Override
    public T visit(DefaultStat d)
    {
        return this.visitDefault(d);
    }
}
