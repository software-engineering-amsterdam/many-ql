package ql.semantics;

import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;
import ql.semantics.values.Value;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Nik on 22-03-2015
 */
public class StoreItems implements FormVisitor<Void>, StatVisitor<Void>, Iterable<String>
{
    private final Map<String, String> questionToId;
    private final ValueTable valueTable;

    public StoreItems(Form ast, ValueTable valueTable)
    {
        this.questionToId = new HashMap<>();
        this.valueTable = valueTable;
        ast.accept(this);
    }

    public String getLabel(String questionId)
    {
        assert this.questionToId.containsKey(questionId);
        return this.questionToId.get(questionId);
    }

    public String getAnswer(String questionId)
    {
        Value v = this.valueTable.getValue(questionId);
        if (v.isUndefined())
        {
            return "";
        }
        return v.toString();
    }

    @Override
    public Iterator iterator()
    {
        return this.questionToId.keySet().iterator();
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
        this.questionToId.put(q.getId(), q.getLabel());
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.questionToId.put(q.getId(), q.getLabel());
        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        return null;
    }
}
