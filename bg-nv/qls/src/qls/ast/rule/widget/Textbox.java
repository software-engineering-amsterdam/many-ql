package qls.ast.rule.widget;

import ql.ast.type.Type;

/**
 * Created by bore on 08/03/15.
 */
public class Textbox extends WidgetValue
{
    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return t.isNumerical() || t.isString();
    }

    @Override
    public <T> T accept(WidgetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
