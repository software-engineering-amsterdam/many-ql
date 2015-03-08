package lang.qls.ast.Rule;

/**
 * Created by bore on 08/03/15.
 */
public class IntRule extends Rule<Integer>
{
    public IntRule(String label, Integer value, int lineNumber)
    {
        super(label, value, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
