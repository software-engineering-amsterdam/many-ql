package lang.ql.semantics;

import lang.ql.ast.expression.*;
import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.*;
import lang.ql.semantics.values.*;

import java.util.*;

/**
 * Created by Nik on 24-2-15.
 */
public class Evaluator implements FormVisitor<ValueTable>, StatVisitor<Void>, ExprVisitor<List<String>>
{
    // TODO: solve double IDs? dunno what to do with that
    private ValueTable valueTable;
    private Map<String, Statement> questions;
    private DependencyTable dependencies;
    private Map<String, List<String>> intermediateDependencies;

    public static ValueTable evaluate(Form f)
    {
        Evaluator evaluator = new Evaluator();
        return evaluator.visit(f);
    }

    public static ValueTable reevaluate(Form f, ValueTable valueTable)
    {
        Evaluator evaluator = new Evaluator(valueTable);
        return  evaluator.visit(f);
    }

    private Evaluator()
    {
        this(new ValueTable());
    }

    private Evaluator(ValueTable valueTable)
    {
        this.valueTable = valueTable;
        this.dependencies = new DependencyTable();
        this.questions = new HashMap<String, Statement>();
        this.intermediateDependencies = new HashMap<String, List<String>>();
    }

    @Override
    public ValueTable visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }

        // build a dependency table
        // TODO: Just... something. This can't stay the way it is now.
        for (String dependantId : this.intermediateDependencies.keySet())
        {
            List<String> subjectIds = this.intermediateDependencies.get(dependantId);

            if (this.questions.containsKey(dependantId))
            {
                Statement dependant = this.questions.get(dependantId);
                for (String subjectId : subjectIds)
                {
                    if (this.questions.containsKey(subjectId))
                    {
                        Statement subject = this.questions.get(subjectId);
                        this.dependencies.addDependant(subject, dependant);
                    }
                }
            }
        }

        return this.valueTable;
    }

    @Override
    public Void visit(Question q)
    {
        this.questions.put(q.getId(), q);

        this.valueTable.storeValue(q.getId(), new UndefinedValue());

        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.questions.put(q.getId(), q);

        Expr expr = q.getCalculation();

        this.intermediateDependencies.put(q.getId(), expr.accept(this));

        Value value = ExprEvaluator.evaluate(expr, this.valueTable);
        this.valueTable.storeValue(q.getId(), value);

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        Expr expr = c.getCondition();
        Value condValue = ExprEvaluator.evaluate(expr, this.valueTable);

        if (!condValue.isUndefined() && !false) // TODO check if the value is Boolean and true
        {
            for (Statement s : c.getBody())
            {
                s.accept(this);
            }
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