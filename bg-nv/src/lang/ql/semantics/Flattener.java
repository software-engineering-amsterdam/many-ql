package lang.ql.semantics;

import lang.ql.ast.form.Form;
import lang.ql.ast.form.FormVisitor;
import lang.ql.ast.statement.CalculatedQuestion;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;
import lang.ql.ast.statement.StatVisitor;

/**
 * Created by Nik on 10-3-15.
 */
public class Flattener implements FormVisitor<Void>, StatVisitor<Void>
{

    public static Flat flatten(Form ast)
    {
        Flattener f = new Flattener();
        return new Flat();
    }

    @Override
    public Void visit(Form f)
    {
        return null;
    }

    @Override
    public Void visit(Question q)
    {
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        return null;
    }
}
