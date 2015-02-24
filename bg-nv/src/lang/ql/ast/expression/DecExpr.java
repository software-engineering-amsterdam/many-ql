package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

import java.math.BigDecimal;

/**
 * Created by bore on 10/02/15.
 */
public class DecExpr extends ConstExpr<BigDecimal>
{
    public DecExpr(BigDecimal value, int lineNumber)
    {
        super(value, lineNumber);
    }

    public <T> T accept(Visitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
