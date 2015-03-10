package lang.qls.ast;

import lang.qls.ast.statement.*;

import java.util.Collection;

/**
 * Created by Nik on 10-3-15.
 */
public class RenderablesCollector implements StylesheetVisitor<Collection<Renderable>>, StatementVisitor<Collection<Renderable>>
{

    @Override
    public Collection<Renderable> visit(Stylesheet s)
    {
        for (Page stat : s.getBody())
        {

        }
        return null;
    }

    @Override
    public Collection<Renderable> visit(Page p)
    {

        for (Statement s : p.getBody())
        {
            // TODO: collect
        }
        return null;
    }

    @Override
    public Collection<Renderable> visit(Section s)
    {
        return null;
    }

    @Override
    public Collection<Renderable> visit(Question q)
    {
        return null;
    }

    @Override
    public Collection<Renderable> visit(QuestionWithRules q)
    {
        return null;
    }

    @Override
    public Collection<Renderable> visit(DefaultStat d)
    {
        return null;
    }

}
