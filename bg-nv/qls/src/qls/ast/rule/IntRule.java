package qls.ast.rule;

/**
 * Created by bore on 08/03/15.
 */
public abstract class IntRule extends Rule
{
    private final Integer value;

    public IntRule(Integer value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }

    public Integer getValue()
    {
        return this.value;
    }
}
