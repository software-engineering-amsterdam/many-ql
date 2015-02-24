package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 14/02/15.
 */
public class Gt extends BinaryExpr
{
    public Gt(Expr left, Expr right, int lineNumber)
    {
        super(left, right, lineNumber);
    }

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
