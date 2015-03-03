package lang.qls.ast.Rule.Widget;

import lang.qls.ast.Rule.RuleVisitor;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Radio extends WidgetRule
{
    private List<String> values;

    public Radio(List<String> values, int lineNumber)
    {
        super(lineNumber);
        this.values = values;
    }

    public List<String> getValues()
    {
        return this.values;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
