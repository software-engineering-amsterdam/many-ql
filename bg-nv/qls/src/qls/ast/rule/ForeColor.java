package qls.ast.rule;

/**
 * Created by bore on 10/03/15.
 */
public class ForeColor extends ColorRule
{
    public ForeColor(ColorValue value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public boolean isOverwrittenBy(Rule r)
    {
        return r.isOverwrittenByForeColor(this);
    }

    @Override
    protected boolean isOverwrittenByForeColor(ForeColor r)
    {
        return true;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
