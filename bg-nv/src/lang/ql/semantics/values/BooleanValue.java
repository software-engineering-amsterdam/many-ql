package lang.ql.semantics.values;

/**
 * Created by bore on 16/02/15.
 */
public class BooleanValue extends Value<Boolean>
{
    public BooleanValue(boolean value)
    {
        super(value);
    }

    public static BooleanValue getDefaultValue()
    {
        return new BooleanValue(false);
    }
}
