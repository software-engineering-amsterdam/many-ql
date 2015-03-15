package ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryExpr extends NaryExpr
{
    private final Expr left;
    private final Expr right;

    // TODO: why don't you let one constructor to call the other, Java? sigh!
    public BinaryExpr(Expr left1, Expr right1, int lineNumber)
    {
        super(lineNumber);
        this.left = left1;
        this.right = right1;
    }

    public BinaryExpr(Expr left, Expr right)
    {
        this.left = left;
        this.right = right;
    }

    public Expr getLeft()
    {
        return this.left;
    }

    public Expr getRight() { return this.right; }
}
