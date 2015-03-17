package qls.ast.rule;

import ql.ast.type.Type;
import qls.ast.rule.widget.WidgetValue;

/**
 * Created by bore on 09/03/15.
 */
public class Widget extends Rule
{
    private final WidgetValue value;

    public Widget(WidgetValue value, int lineNumber)
    {
        super(lineNumber);
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

    public WidgetValue getValue()
    {
        return this.value;
    }
}
