package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.type.Type;

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
}
