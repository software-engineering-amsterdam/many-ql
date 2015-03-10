package lang.qls.ast.rule.widget;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Spinbox extends NumWidgetValue
{
    public Spinbox(Integer min, Integer max, Integer step)
    {
        super("spinbox", min, max, step);
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isNumerical();
    }
}
