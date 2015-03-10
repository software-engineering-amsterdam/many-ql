package lang.qls.ast.rule;

import lang.ql.ast.type.Type;
import lang.qls.ast.rule.widget.WidgetValue;

/**
 * Created by bore on 09/03/15.
 */
public class Widget extends Rule
{
    private final WidgetValue value;

    public Widget(WidgetValue value, int lineNumber)
    {
        super("widget", lineNumber);
        this.value = value;
    }

    @Override
    public boolean isCompatibleWithType(Type t)
    {
        return this.value.isCompatibleWithType(t);
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
