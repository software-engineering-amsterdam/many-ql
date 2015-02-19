package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 16/02/15.
 */
public class And extends BinaryExpr
{
    public And(Expr left, Expr right)
    {
        super(left, right);
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
}
