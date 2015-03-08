package lang.qls.ast.Rule;

import lang.qls.ast.Rule.WidgetValue.WidgetValue;

/**
 * Created by bore on 08/03/15.
 */
public class WidgetRule extends Rule<WidgetValue>
{
    public WidgetRule(String label, WidgetValue value, int lineNumber)
    {
        super(label, value, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
