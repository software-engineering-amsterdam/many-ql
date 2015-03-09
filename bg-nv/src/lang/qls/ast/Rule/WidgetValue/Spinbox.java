package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Spinbox extends WidgetValue
{
    private Integer min;
    private Integer max;

    public Spinbox()
    {
        super("spinbox");
    }

    public Spinbox(Integer min, Integer max)
    {
        this();
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isNumerical();
    }
}
