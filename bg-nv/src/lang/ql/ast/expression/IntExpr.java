package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

/**
 * Created by bore on 09/02/15.
 */
public class IntExpr extends ConstExpr<Integer>
{
    public IntExpr(int value, int lineNumber)
    {
        super(value, lineNumber);
    }

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
