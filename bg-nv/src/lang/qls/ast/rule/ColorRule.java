package lang.qls.ast.rule;

/**
 * Created by bore on 09/03/15.
 */
public abstract class ColorRule extends Rule
{
    private ColorValue value;

    public ColorRule(String label, ColorValue value, int lineNumber)
    {
        super(label, lineNumber);
        this.value = value;
    }
}
