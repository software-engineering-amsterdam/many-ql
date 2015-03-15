package ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public class Ident extends Expr
{
    private final String id;

    public Ident(String id, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }

    @Override
    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
