package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 10/02/15.
 */
public class BooleanExpr extends ConstantExpr<Boolean>
{
    public BooleanExpr(Boolean value)
    {
        super(value);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
