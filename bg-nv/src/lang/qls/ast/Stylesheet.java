package lang.qls.ast;

import lang.ql.ast.AstNode;

import java.util.List;

/**
 * Created by bore on 27/02/15.
 */
public class Stylesheet extends AstNode
{
    private String id;
    private List<Page> body;

    public Stylesheet(String id, List<Page> body, int lineNumber)
    {
        super(lineNumber);
        this.id = id;
        this.body = body;
    }

    public String getId()
    {
        return this.id;
    }

    public List<Page> getBody()
    {
        return this.body;
    }
}
