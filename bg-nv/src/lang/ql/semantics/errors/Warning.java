package lang.ql.semantics.errors;

/**
 * Created by bore on 20/02/15.
 */
public class Warning extends Message
{
    public Warning(String message)
    {
        super(message);
    }

    @Override
    public boolean isError()
    {
        return false;
    }

    public static Warning labelDuplication(String idList)
    {
        return new Warning(String.format("The following questions have identical labels: %s", idList));
    }
}
