package lang.ql.ast.expression;

import lang.ql.semantics.Visitor;

import java.math.BigDecimal;

/**
 * Created by bore on 10/02/15.
 */
public class DecExpr extends ConstExpr<BigDecimal>
{
    public DecExpr(BigDecimal value)
    {
        super(value);
    }

    public void accept(Visitor visitor) { visitor.visit(this); }
}
