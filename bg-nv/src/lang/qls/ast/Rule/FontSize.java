package lang.qls.ast.Rule;

/**
 * Created by bore on 02/03/15.
 */
public class FontSize extends Rule<Integer>
{
    public FontSize(int fontSize, int lineNumber)
    {
        super(fontSize, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
