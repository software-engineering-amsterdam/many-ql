package qls.ast;

import ql.ast.AstNode;
import qls.ast.statement.Statement;
import qls.ast.statement.StyleCollector;
import qls.semantics.Style;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Page extends AstNode implements Styleable
{
    private final String name;
    private final List<Statement> body;
    private final Style style;

    public Page(String name, List<Statement> body, int lineNumber)
    {
        super(lineNumber);
        this.name = name;
        this.body = body;

        StyleCollector c = new StyleCollector();
        this.style = c.visit(this);
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
    public Style getStyle()
    {
        return this.style;
    }

    public <T> T accept(StylesheetVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
