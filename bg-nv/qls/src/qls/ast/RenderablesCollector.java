package qls.ast;

import ql.ast.statement.*;
import ql.ast.statement.Question;
import qls.ast.Page;
import qls.ast.Renderable;
import qls.ast.Stylesheet;
import qls.ast.StylesheetVisitor;
import qls.ast.statement.*;

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

        for (qls.ast.statement.Statement s : p.getBody())
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
    public Collection<Renderable> visit(qls.ast.statement.Question q)
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
