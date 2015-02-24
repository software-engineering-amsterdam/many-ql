package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 10/02/15.
 */
public class BoolExpr extends ConstExpr<Boolean>
{
    public BoolExpr(Boolean value, int lineNumber)
    {
        super(value, lineNumber);
    }

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
