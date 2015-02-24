package lang.ql.semantics.values;

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

    public <T> T accept (ValueVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
