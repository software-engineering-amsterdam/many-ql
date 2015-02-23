package lang.ql.semantics.values;

import lang.ql.semantics.ValueVisitor;

import java.util.Date;

/**
 * Created by Nik on 22-02-2015
 */
// TODO: implement necessary operations
public class DateValue extends Value<Date>
{
    public DateValue(Date value)
    {
        super(value);
    }

    public static DateValue getDefaultValue()
    {
        return new DateValue(new Date());
    }

    @Override
    public void accept(ValueVisitor visitor)
    {
        visitor.visit(this);
    }
}
