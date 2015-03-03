package lang.qls.ast.Statement;

/**
 * Created by bore on 02/03/15.
 */
public class Question extends Statement
{
    private String id;

    public Question(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }
}
