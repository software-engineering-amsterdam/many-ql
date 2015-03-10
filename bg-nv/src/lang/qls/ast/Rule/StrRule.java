package lang.qls.ast.rule;

/**
 * Created by bore on 08/03/15.
 */
public abstract class StrRule  extends Rule
{
    private String value;

    public StrRule(String label, String value, int lineNumber)
    {
        super(label, lineNumber);
        this.value = value;
    }
}
