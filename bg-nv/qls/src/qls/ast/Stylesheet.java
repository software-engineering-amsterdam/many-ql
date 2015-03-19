package qls.ast;

import ql.ast.AstNode;
import qls.ast.statement.Statement;

import java.util.List;

/**
 * Created by bore on 27/02/15.
 */
public class Stylesheet extends AstNode
{
    private final String id;
    private final List<Page> body;

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

    public <T> T accept(StylesheetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
