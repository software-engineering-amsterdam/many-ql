package lang.qls.ast.rule;

/**
 * Created by bore on 09/03/15.
 */
public class Font extends StrRule
{
    public Font(String value, int lineNumber)
    {
        super("font", value, lineNumber);
    }

    @Override
    public boolean isOverwrittenBy(Rule r)
    {
        return r.isOverwrittenByFont(this);
    }

    @Override
    protected boolean isOverwrittenByFont(Font r)
    {
        return true;
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
