package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 16/02/15.
 */
public class Or extends BinaryExpr
{
    public Or(Expr left, Expr right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
