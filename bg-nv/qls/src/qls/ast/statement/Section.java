package qls.ast.statement;

import qls.ast.RenderableParent;
import qls.ast.Styleable;
import qls.semantics.Style;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Section extends Statement implements Styleable, RenderableParent
{
    private final String name;
    private final List<Statement> body;

    public Section(String name, List<Statement> body, int lineNumber)
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
    public boolean isStyleDefinition()
    {
        return false;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }

    @Override
    public Style getStyle()
    {
        DefaultStyleCollector visitor = new DefaultStyleCollector();
        return visitor.visit(this);
    }

    @Override
    public List<Statement> getRenderableChildren()
    {
        return null;
    }
}
