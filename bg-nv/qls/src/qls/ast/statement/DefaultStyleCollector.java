package qls.ast.statement;

import qls.ast.Page;
import qls.ast.Stylesheet;
import qls.ast.StylesheetVisitor;
import qls.semantics.Style;

/**
 * Created by bore on 09/03/15.
 */
public class DefaultStyleCollector implements StylesheetVisitor<Style>, StatementVisitor<Style>
{
    @Override
    public Style visit(Stylesheet s)
    {
        return new Style();
    }

    @Override
    public Style visit(Page p)
    {
        return this.extractStyle(p.getBody());
    }

    @Override
    public Style visit(Section s)
    {
        return this.extractStyle(s.getBody());
    }

    private Style extractStyle(Iterable<qls.ast.statement.Statement> stats)
    {
        Style result = new Style();
        for (qls.ast.statement.Statement stat : stats)
        {
            if (stat.isStyleDefinition())
            {
                Style statStyle = stat.accept(this);
                result.addStyle(statStyle);
            }
        }

        return result;
    }

    @Override
    public Style visit(DefaultStat d)
    {
        Style result = new Style();
        result.addRules(d.getType(), d.getBody());
        return result;
    }

    @Override
    public Style visit(Question q)
    {
        return new Style();
    }

    @Override
    public Style visit(QuestionWithRules q)
    {
        return new Style();
    }
}
