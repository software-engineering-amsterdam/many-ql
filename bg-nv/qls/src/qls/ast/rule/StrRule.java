package qls.ast.rule;

/**
 * Created by bore on 08/03/15.
 */
public abstract class StrRule  extends Rule
{
    private String value;

    public StrRule(String value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }
}
