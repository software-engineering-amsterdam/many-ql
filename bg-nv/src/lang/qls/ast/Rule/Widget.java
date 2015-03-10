package lang.qls.ast.Rule;

import lang.ql.ast.type.Type;
import lang.qls.ast.Rule.WidgetValue.WidgetValue;

/**
 * Created by bore on 09/03/15.
 */
public class Widget extends WidgetRule
{
    public Widget(WidgetValue value, int lineNumber)
    {
        super("widget", value, lineNumber);
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return this.getValue().isCompatibleWithType(t);
    }

    @Override
    public boolean isOverwrittenBy(Rule r)
    {
        return r.isOverwrittenByWidget(this);
    }

    @Override
    protected boolean isOverwrittenByWidget(Widget r)
    {
        return true;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
