package lang.ql.semantics.errors;

import lang.ql.ast.types.Type;

/**
 * Created by bore on 20/02/15.
 */
public class Warning extends Message
{
    public static Warning labelDuplication(String id)
    {
        return new Warning(String.format("Question with the same label is already defined", id));
    }

    public Warning(String message)
    {
        super(message);
    }
}
