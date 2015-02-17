package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class IntExpr extends ConstExpr<Integer>
{
    public IntExpr(int value)
    {
        super(value);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
