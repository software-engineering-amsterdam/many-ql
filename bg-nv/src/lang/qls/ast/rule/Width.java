package lang.qls.ast.rule;

/**
 * Created by bore on 09/03/15.
 */
public class Width extends IntRule
{
    public Width(Integer value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public boolean isOverwrittenBy(Rule r)
    {
        return r.isOverwrittenByWidth(this);
    }

    @Override
    protected boolean isOverwrittenByWidth(Width r)
    {
        return true;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
