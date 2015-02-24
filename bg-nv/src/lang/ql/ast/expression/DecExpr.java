package lang.ql.ast.expression;

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

    public <T> T accept(ExprVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
