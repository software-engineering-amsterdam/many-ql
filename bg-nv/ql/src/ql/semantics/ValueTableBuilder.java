package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.semantics.values.UndefValue;

/**
 * Created by Nik on 24-2-15.
 */
public class ValueTableBuilder implements FormVisitor<Void>, StatVisitor<Void>
{
    private final ValueTable valueTable;
    private final UndefValue undefValue = new UndefValue();

    public static ValueTable build(Form f)
    {
        ValueTableBuilder valueTableBuilder = new ValueTableBuilder();
        f.accept(valueTableBuilder);

        return valueTableBuilder.valueTable;
    }

    private ValueTableBuilder()
    {
        this.valueTable = new ValueTable();
    }

    @Override
    public Void visit(Form f)
    {
        for (Statement s : f.getBody())
        {
            s.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.valueTable.storeValue(q.getId(), undefValue);
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.valueTable.storeValue(q.getId(), undefValue);
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
}