package lang.ql.semantics.values;

import lang.ql.semantics.ValueVisitor;

/**
 * Created by bore on 23/02/15.
 */
public class UndefinedValue extends Value<String>
{
    public UndefinedValue(String value)
    {
        super("");
    }

    @Override
    public void accept(ValueVisitor visitor)
    {
        visitor.visit(this);
    }
}
