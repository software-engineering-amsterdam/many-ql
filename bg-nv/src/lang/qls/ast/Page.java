package lang.qls.ast;

import lang.ql.ast.AstNode;
import lang.qls.ast.Statement.Statement;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Page extends AstNode
{
    private String name;
    private List<Statement> body;

    public Page(String name, List<Statement> body, int lineNumber)
    {
        super(lineNumber);
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

    public <T> T accept(StylesheetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
