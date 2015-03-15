package qls.ast.rule;

/**
 * Created by bore on 09/03/15.
 */
public abstract class ColorRule extends Rule
{
    private ColorValue value;

    public ColorRule(ColorValue value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }
}
