package lang.qls.ast.Rule;

/**
 * Created by bore on 09/03/15.
 */
public class BackColor extends ColorRule
{
    public BackColor(ColorValue value, int lineNumber)
    {
        super("color", value, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
