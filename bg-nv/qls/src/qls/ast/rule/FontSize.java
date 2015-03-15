package qls.ast.rule;

/**
 * Created by bore on 09/03/15.
 */
public class FontSize extends IntRule
{
    public FontSize(Integer value, int lineNumber)
    {
        super(value, lineNumber);
    }

    @Override
    public boolean isOverwrittenBy(Rule r)
    {
        return r.isOverwrittenByFontSize(this);
    }

    @Override
    protected boolean isOverwrittenByFontSize(FontSize r)
    {
        return true;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
