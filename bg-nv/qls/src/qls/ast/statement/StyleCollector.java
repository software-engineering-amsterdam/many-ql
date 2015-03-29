package qls.ast.statement;

import qls.ast.Page;
import qls.ast.Stylesheet;
import qls.ast.StylesheetVisitor;
import qls.semantics.Style;

/**
 * Created by bore on 09/03/15.
 */
public class StyleCollector extends DefaultStatementVisitor<Style> implements StylesheetVisitor<Style>
{
    private static final Style style = new Style();

    @Override
    public Style visit(Page p)
    {
        return this.constructStyle(p.getBody());
    }

    @Override
    public Style visit(Section s)
    {
        return this.constructStyle(s.getBody());
    }

    @Override
    public Style visit(DefaultStat d)
    {
        Style result = new Style();
        result.addRules(d.getType(), d.getBody());
        return result;
    }

    @Override
    public Style visit(Stylesheet s)
    {
        return style;
    }

    @Override
    public Style visitDefault(Statement s)
    {
        return style;
    }

    private Style constructStyle(Iterable<qls.ast.statement.Statement> stats)
    {
        Style result = new Style();
        for (Statement stat : stats)
        {
            if (stat.isStyleDefinition())
            {
                Style statStyle = stat.accept(this);
                result.addStyle(statStyle);
            }
        }

        return result;
    }
}
