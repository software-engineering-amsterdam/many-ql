package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nik on 02-03-2015
 */
public class DependencyResolver implements FormVisitor<DependencyTable>, StatVisitor<Void>, ExprVisitor<List<String>>
{
    private DependencyTable dependencies;

    public static DependencyTable resolve(Form f)
    {
        ValueTable table = new ValueTable();
        DependencyResolver resolver = new DependencyResolver();
        return f.accept(resolver);
    }

    private DependencyResolver()
    {
        this.dependencies = new DependencyTable();
    }

    @Override
    public DependencyTable visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }

        return this.dependencies;
    }

    @Override
    public Void visit(Question q)
    {
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        Expr expr = q.getCalculation();

        List<String> deps = expr.accept(this);
        for (String d : deps)
        {
            this.dependencies.addDependant(q.getId(), d);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        for (Statement s : c.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public List<String> visit(BoolExpr e)
    {
        return Collections.emptyList();
    }

    @Override
    public List<String> visit(IntExpr e)
    {
        return Collections.emptyList();
    }

    @Override
    public List<String> visit(DecExpr e)
    {
        return Collections.emptyList();
    }

    @Override
    public List<String> visit(StrExpr e)
    {
        return Collections.emptyList();
    }

    @Override
    public List<String> visit(Ident id)
    {
        List<String> ids = new ArrayList<String>();
        ids.add(id.getId());
        return ids;
    }

    @Override
    public List<String> visit(Neg e)
    {
        return e.getOperand().accept(this);
    }

    @Override
    public List<String> visit(Pos e)
    {
        return e.getOperand().accept(this);
    }

    @Override
    public List<String> visit(Not e)
    {
        return e.getOperand().accept(this);
    }

    @Override
    public List<String> visit(Add e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Sub e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Mul e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Div e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Gt e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Lt e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(GtEqu e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(LtEqu e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Equ e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(NotEqu e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(And e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }

    @Override
    public List<String> visit(Or e)
    {
        List<String> ids = e.getLeft().accept(this);
        ids.addAll(e.getRight().accept(this));
        return ids;
    }
}
