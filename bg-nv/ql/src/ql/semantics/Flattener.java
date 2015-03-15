package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.CalculatedQuestion;
import ql.ast.statement.IfCondition;
import ql.ast.statement.Question;
import ql.ast.statement.StatVisitor;

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
