package qls.ast.statement;

import qls.ast.Styleable;
import qls.semantics.Style;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class Section extends Statement implements Styleable
{
    private final String name;
    private final List<Statement> body;
    private final Style style;

    public Section(String name, List<Statement> body, int lineNumber)
    {
        super(lineNumber);
        this.name = name;
        this.body = body;

        StyleCollector c = new StyleCollector();
        this.style = this.accept(c);
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
        return this.style;
    }

    @Override
    public boolean isRenderable()
    {
        return true;
    }
}
