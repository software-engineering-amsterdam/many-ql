package lang.ql.ast.expression;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryExpr extends Expr
{
    private Expr left;
    private Expr right;

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
