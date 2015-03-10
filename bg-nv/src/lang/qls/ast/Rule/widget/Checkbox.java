package lang.qls.ast.rule.widget;

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

    @Override
    public <T> T accept(WidgetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
