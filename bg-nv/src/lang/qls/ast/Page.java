package lang.qls.ast;

import lang.ql.ast.AstNode;
import lang.qls.ast.Statement.DefaultStyle;
import lang.qls.ast.Statement.Statement;
import lang.qls.semantics.Style;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Page extends AstNode implements Styleable
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

    @Override
    public Style getDefaultStyle()
    {
        DefaultStyle visitor = new DefaultStyle();
        return visitor.visit(this);
    }

    public <T> T accept(StylesheetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
