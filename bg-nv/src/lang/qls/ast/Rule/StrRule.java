package lang.qls.ast.Rule;

/**
 * Created by bore on 08/03/15.
 */
public abstract class StrRule  extends Rule<String>
{
    public StrRule(String label, String value, int lineNumber)
    {
        super(label, value, lineNumber);
    }
}
