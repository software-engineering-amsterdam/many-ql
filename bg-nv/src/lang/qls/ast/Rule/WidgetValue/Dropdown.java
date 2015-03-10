package lang.qls.ast.Rule.WidgetValue;

import lang.ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Dropdown extends BoolWidgetValue
{
    public Dropdown(String yesLabel, String noLabel)
    {
        super("dropdown", yesLabel, noLabel);
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isBool();
    }
}
