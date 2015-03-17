package ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryExpr extends NaryExpr
{
    private final Expr left;
    private final Expr right;

    public BinaryExpr(Expr left, Expr right)
    {
        this.left = left;
        this.right = right;
    }

    public BinaryExpr(Expr left, Expr right, int lineNumber)
    {
        super(lineNumber);
        this.left = left;
        this.right = right;
    }

    public Expr getLeft()
    {
        return this.left;
    }

    public Expr getRight() { return this.right; }
}
