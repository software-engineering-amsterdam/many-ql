package lang.qls.ast.Rule;

/**
 * Created by bore on 08/03/15.
 */
public abstract class IntRule extends Rule<Integer>
{
    public IntRule(String label, Integer value, int lineNumber)
    {
        super(label, value, lineNumber);
    }
}
