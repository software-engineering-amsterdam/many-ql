package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Checkbox extends WidgetValue
{
    public Checkbox()
    {
        super("checkbox");
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isBool();
    }
}
