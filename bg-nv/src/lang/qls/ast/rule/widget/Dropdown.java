package lang.qls.ast.rule.widget;

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

    @Override
    public <T> T accept(WidgetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
