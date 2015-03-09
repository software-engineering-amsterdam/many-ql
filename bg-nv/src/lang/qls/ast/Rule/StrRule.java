package lang.qls.ast.Rule;

/**
 * Created by bore on 08/03/15.
 */
public class StrRule  extends Rule<String>
{
    public StrRule(String label, String value, int lineNumber)
    {
        super(label, value, lineNumber);
    }

    @Override
    public <T> T accept(RuleVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
