package lang.qls.ast.Rule;

/**
 * Created by bore on 02/03/15.
 */
public abstract class Rule<T> extends StylesheetRule
{
    private T value;

    public Rule(T value, int lineNumber)
    {
        super(lineNumber);
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }
}