package lang.ql.ast.expression;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 09/02/15.
 */
public abstract class BinaryExpr extends NaryExpr
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

    @Override
    public boolean isTypeAllowed(Type t)
    {
        return t.isArithmetic();
    }
}
