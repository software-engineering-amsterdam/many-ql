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
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
