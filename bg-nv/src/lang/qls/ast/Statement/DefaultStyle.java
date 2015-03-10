package lang.qls.ast.Statement;

import lang.qls.ast.Page;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;
import lang.qls.semantics.Style;

/**
 * Created by bore on 09/03/15.
 */
public class DefaultStyle implements StylesheetVisitor<Style>, StatementVisitor<Style>
{
    @Override
    public Style visit(Stylesheet s)
    {
        return new Style();
    }

    @Override
    public Style visit(Page p)
    {
        Style result = new Style();
        for (Statement stat : p.getBody())
        {
            Style statStyle = stat.accept(this);
            result.addStyle(statStyle);
        }

        return result;
    }

    @Override
    public Style visit(Section s)
    {
        Style result = new Style();
        for (Statement stat : s.getBody())
        {
            Style statStyle = stat.accept(this);
            result.addStyle(statStyle);
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
