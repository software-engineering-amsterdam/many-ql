package lang.qls.ast.Rule;

/**
 * Created by bore on 02/03/15.
 */
public class Font extends Rule<String>
{
    public Font(String font, int lineNumber)
    {
        super(font, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}