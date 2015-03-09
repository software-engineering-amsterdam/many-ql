package lang.qls.ast.Rule;

/**
 * Created by bore on 09/03/15.
 */
public abstract class ColorRule extends Rule<ColorValue>
{
    public ColorRule(String label, ColorValue value, int lineNumber)
    {
        super(label, value, lineNumber);
    }
}
