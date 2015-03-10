package lang.ql.semantics.errors;

import java.util.List;

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

    public static Warning labelDuplication(List<String> ids)
    {
        return new Warning("Questions with ids The same label already defined" + Message.getListString(ids));
    }
}
