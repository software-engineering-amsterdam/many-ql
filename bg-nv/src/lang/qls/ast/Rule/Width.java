package lang.qls.ast.Rule;

/**
 * Created by bore on 02/03/15.
 */
public class Width extends Rule<Integer>
{
    public Width(int width, int lineNumber)
    {
        super(width, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
