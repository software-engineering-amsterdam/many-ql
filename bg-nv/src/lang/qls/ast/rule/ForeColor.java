package lang.qls.ast.rule;

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
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
