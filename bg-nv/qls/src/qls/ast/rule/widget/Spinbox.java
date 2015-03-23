package qls.ast.rule.widget;

import ql.ast.type.Type;

import java.math.BigDecimal;

/**
 * Created by bore on 08/03/15.
 */
public class Spinbox extends NumWidgetValue
{
    public Spinbox(BigDecimal min, BigDecimal max, BigDecimal step)
    {
        super("spinbox", min, max, step);
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isNumerical();
    }

    @Override
    public <T> T accept(WidgetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
