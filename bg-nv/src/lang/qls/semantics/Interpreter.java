package lang.qls.semantics;

import lang.qls.ast.Page;
import lang.qls.ast.Statement.*;
import lang.qls.ast.Stylesheet;
import lang.qls.ast.StylesheetVisitor;

/**
 * Created by bore on 09/03/15.
 */
public class Interpreter implements StylesheetVisitor<Void>, StatementVisitor<Void>
{
    @Override
    public Void visit(Stylesheet s)
    {
        return null;
    }

    @Override
    public Void visit(Page p)
    {
        return null;
    }

    @Override
    public Void visit(Section s)
    {
        return null;
    }

    @Override
    public Void visit(Question q)
    {
        return null;
    }

    @Override
    public Void visit(QuestionWithRules q)
    {
        return null;
    }

    @Override
    public Void visit(DefaultStat d)
    {
        return null;
    }
}
