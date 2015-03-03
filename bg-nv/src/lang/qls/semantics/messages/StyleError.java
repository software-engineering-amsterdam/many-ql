package lang.qls.semantics.messages;

/**
 * Created by bore on 03/03/15.
 */
public class StyleError extends lang.ql.semantics.errors.Error
{
    private StyleError(String m)
    {
        super(m);
    }

    public static StyleError questionAlreadyReferenced(String id, int line)
    {
        String m = String.format("Error (Line %d): question with id %s is already referenced on line %d",
                line, id, line);

        return new StyleError(m);
    }

    public static StyleError undefinedQuestion(String id, int line)
    {
        return new StyleError(String.format("Error (Line %d): question with id %s is not defined", line, id));
    }

    public static StyleError questionNotReferenced(String id)
    {
        return new StyleError(String.format("Error: question with id %s is not referenced in the stylesheet", id));
    }
}
