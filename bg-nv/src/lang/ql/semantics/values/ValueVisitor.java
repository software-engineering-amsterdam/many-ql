package lang.ql.semantics.values;

/**
 * Created by Nik on 22-02-2015
 */
public interface ValueVisitor<T>
{
    public T visit(BooleanValue val);
    public T visit(DateValue val);
    public T visit(DecimalValue val);
    public T visit(IntegerValue val);
    public T visit(StringValue val);
}
