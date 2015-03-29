package qls.ast.rule.widget;

import ql.ast.type.Type;

/**
 * Created by bore on 29/03/15.
 */
public class IntSlider extends NumWidgetValue <Integer>
{
    public IntSlider(Integer min, Integer max, Integer step)
    {
        super(min, max, step);
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
