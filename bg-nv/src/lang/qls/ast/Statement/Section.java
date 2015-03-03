package lang.qls.ast.Statement;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Section extends Statement
{
    private String name;
    private List<Statement> body;

    public Section(String name, List<Statement> body)
    {
        this.name = name;
        this.body = body;
    }

    public String getName()
    {
        return this.name;
    }

    public List<Statement> getBody()
    {
        return this.body;
    }
}
