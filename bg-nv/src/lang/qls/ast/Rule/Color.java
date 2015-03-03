package lang.qls.ast.Rule;

/**
 * Created by bore on 02/03/15.
 */
public class Color extends Rule<String>
{
    public Color(String color, int lineNumber)
    {
        super(color, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
