package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 17/02/15.
 */
public class LtEqu extends BinaryExpr
{
    public LtEqu(Expr left, Expr right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
