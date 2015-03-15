package qls.ast.rule.widget;

import ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Slider extends NumWidgetValue
{
    public Slider(Integer min, Integer max, Integer step)
    {
        super("slider", min, max, step);
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
