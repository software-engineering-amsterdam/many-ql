package ql.semantics.values;

/**
 * Created by Nik on 22-02-2015
 */
public interface ValueVisitor<T>
{
    public T visit(BoolValue val);
    public T visit(DecValue val);
    public T visit(IntValue val);
    public T visit(StrValue val);
    public T visit(UndefValue val);
}
